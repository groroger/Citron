package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al33.citron.IBusiness.EntrepotIBusiness;
import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.citron.entity.CallWsLivraison;
import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Commande;
import fr.afcepf.al33.citron.entity.Facture;

@ManagedBean(name = "mbMaFacture")
@SessionScoped
public class MaFactureManagedBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // @ManagedProperty(value="#{mbConnectionUtilisateur.clientConnecte}")
    // private Client client;
    private Client clientConnecte;

    // Get commande object from Panier bean
    @ManagedProperty(value = "#{mbPanier.commande}")
    private Commande commande;

    @ManagedProperty(value="#{mbPanier.articlesCommandes}")
    private List<ArticleCommande> articlesCommandes;
    
    private Double prixTotal;

    @EJB
    private EntrepotIBusiness proxyEntrepot;

    private Facture facture;

    @PostConstruct
    public void init()  {

        ConnectionUtilisateurManagedBean mbConnectionUtilisateur = (ConnectionUtilisateurManagedBean) FacesContext
                .getCurrentInstance().getExternalContext().getSessionMap().get("mbConnectionUtilisateur");
        this.clientConnecte = mbConnectionUtilisateur.getClientConnecte();

        Facture fact = new Facture();

        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(commande.getDateCreation());
        String year = String.valueOf(cal.get(Calendar.YEAR));
        String month = String.valueOf(cal.get(Calendar.MONTH));
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        String myCommandeDate = day + "/" + month + "/" + year;
        
        System.out.println("======= Here ville Entrepot ======="+ proxyEntrepot.searchById(1).getVille());
        String adresseEntrepot = proxyEntrepot.searchById(1).getAdresse() + " " 
        						+ proxyEntrepot.searchById(1).getVille().getCodePostal() + " " 
                				+ proxyEntrepot.searchById(1).getVille().getNom();
        String adresseClient = clientConnecte.getAdresseLivraison() + " " 
                				+ clientConnecte.getVilleLivraison().getCodePostal()+ " " 
                        		+ clientConnecte.getVilleLivraison().getNom();        
        // String idFacture = clientConnecte.getPrenom().substring(0, 1)+
        // clientConnecte.getNom().substring(0, 2)+"-"+year + month + day;
        String idFacture = clientConnecte.getPrenom().substring(0, 1) + clientConnecte.getNom().substring(0, 2) + "-"
                + commande.getDateCreation().toString();
        
        System.out.println(adresseEntrepot);
        
        CallWsLivraison infoLivraison = new CallWsLivraison();
        infoLivraison.setCompany("Citron");
        infoLivraison.setId_facture(idFacture);
        infoLivraison.setAddress_a(adresseEntrepot);
        infoLivraison.setAddress_b(adresseClient);
        // infoLivraison.setDate_commande(commande.getDateCreation());
        // infoLivraison.setDate_commande(new
        // SimpleDateFormat("dd/MM/yyyy").parse(myCommandeDate));

        // Call the post methode of the livraison web service to create a new call with
        // CO2 and delivry cost
        javax.ws.rs.client.Client jaxrs2client = ClientBuilder.newClient();
        //String urlWsLivraison = "http://localhost:7575/livraison/svccall";
        String urlWsLivraison = "http://192.168.102.88:7575/livraison/svccall";
        WebTarget productsTarget = jaxrs2client.target(urlWsLivraison);
        Response responseCallWsLivraison = productsTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(infoLivraison, MediaType.APPLICATION_JSON_TYPE));
        if (responseCallWsLivraison.getStatus() == 200 /* OK */) {
            String returnme = responseCallWsLivraison.getLocation().toString();
            System.out.println("responseCallWsLivraison.getLocation().toString() POST -> "
                    + responseCallWsLivraison.getHeaderString(null) + " --->");

            // Call the get methode of the livraison web service to get back the CO2 and
            // delivery cost
            javax.ws.rs.client.Client jaxrs2client2 = ClientBuilder.newClient();
            String[] parts = returnme.split("/");
            String livraisonGetRestUrl = urlWsLivraison+"/"+parts[4];// returnme;
            System.out.println("responseCallWsLivraison.getLocation().toString() livraisonGetRestUrl -> " + livraisonGetRestUrl);
            WebTarget livraisonTarget = jaxrs2client2.target(livraisonGetRestUrl);
            CallWsLivraison infoLivraison2 = livraisonTarget.request(MediaType.APPLICATION_JSON)
                    .get(CallWsLivraison.class);
            ;
            System.out.println(
                    "responseCallWsLivraison.getLocation().toString() GET CO2 -> " + infoLivraison2.getCo2_footprint()+" & shipping price -> " + infoLivraison2.getDelivery_price());

            fact.setId(idFacture);
            fact.setClient(clientConnecte);
            fact.setCommande(commande);
            fact.setDate_creation(commande.getDateCreation());
            fact.setDelivery_price(infoLivraison2.getDelivery_price());
            fact.setCo2_footprint(infoLivraison2.getCo2_footprint());
            fact.setClient(clientConnecte);
            fact.setCommande(commande);
            this.facture = fact;
            prixTotal = commande.getPrixTotal()+infoLivraison2.getDelivery_price();
            
           System.out.println(articlesCommandes.size());
           
        } else {
            System.out.println("MaFactureManagedBean.init -> Trouble to get the Post OK for the livraison WS");
        }

    }

    public void valider() {
        System.out.println("=================================================================");
        System.out.println(clientConnecte.getAdresseLivraison());
        System.out.println(clientConnecte.toString());

        System.out.println("=================================================================");
    }

    public Client getClient() {
        return clientConnecte;
    }

    public void setClient(Client client) {
        this.clientConnecte = client;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

	public Client getClientConnecte() {
		return clientConnecte;
	}

	public void setClientConnecte(Client clientConnecte) {
		this.clientConnecte = clientConnecte;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public List<ArticleCommande> getArticlesCommandes() {
		return articlesCommandes;
	}

	public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
		this.articlesCommandes = articlesCommandes;
	}
	
    

}
