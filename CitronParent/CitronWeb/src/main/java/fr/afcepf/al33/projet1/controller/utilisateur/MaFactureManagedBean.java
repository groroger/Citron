package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.afcepf.al33.citron.IBusiness.EntrepotIBusiness;
import fr.afcepf.al33.citron.entity.CallWsLivraison;
import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Commande;
import fr.afcepf.al33.citron.entity.Facture;


@ManagedBean(name="mbMaFacture")
@SessionScoped
public class MaFactureManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty(value="#{mbConnectionUtilisateur.clientConnecte}")
	//private Client client;
	private Client clientConnecte;
	
	//@ManagedProperty(value="#{mbPanier.commande}")
	private Commande commande; 
	
	@EJB 
	private EntrepotIBusiness proxyEntrepot;
	
	private Facture facture;

	@PostConstruct
	public void init() {
		
		PanierManagedBean mbPanier = (PanierManagedBean) 
				FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("mbPanier");
		this.commande = mbPanier.getCommande();
		
		ConnectionUtilisateurManagedBean mbConnectionUtilisateur = (ConnectionUtilisateurManagedBean)
				FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("mbConnectionUtilisateur");
		this.clientConnecte = mbConnectionUtilisateur.getClientConnecte();
		
		// here  we should call our web-service :
		Facture facture = new Facture();
		//Long pk = null;
		
		// Choose time zone in which you want to interpret your Date
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
		cal.setTime(commande.getDateCreation());
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH));
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		
		String adresseEntrepot = proxyEntrepot.searchById(1).getAdresse();
		String adresseClient = clientConnecte.getAdresseLivraison();
		String idFacture = clientConnecte.getPrenom().substring(0, 1)
				         + clientConnecte.getNom().substring(0, 1)
				         + year + month + day;
		
		CallWsLivraison infoLivraison = new CallWsLivraison();
		infoLivraison.setCompany("Citron");
		infoLivraison.setId_facture(idFacture);
		infoLivraison.setAddress_a(adresseEntrepot);
		infoLivraison.setAddress_b(adresseClient);
		infoLivraison.setDate_commande(commande.getDateCreation());
		
		
		
		javax.ws.rs.client.Client jaxrs2client = ClientBuilder.newClient();
		WebTarget productsTarget = jaxrs2client.target("http://localhost:7575/livraison/svccall");
		Response responseCallWsLivraison = productsTarget.request(MediaType.APPLICATION_JSON_TYPE)
									.post(Entity.entity(infoLivraison, MediaType.APPLICATION_JSON_TYPE) );
		if(responseCallWsLivraison.getStatus() == 200 /*OK*/){
		//String savedCallWsLivraisonAsJsonString = responseSaveNewCallWsLivraison.readEntity(String.class);
		//CallWsLivraison savedProd = responseCallWsLivraison.readEntity(CallWsLivraison.class);
		String returnme =responseCallWsLivraison.getLocation().toString();
		System.out.println(returnme);
		}
//		pk=savedProd.getId();
//		System.out.println("(saved) new product with auto_incremented pk = " + pk
//		+ "\n\t " + savedProd.toString());
//		}else{System.err.println(responseCallWsLivraison);
//		}
		
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
	
	
	
	
}
