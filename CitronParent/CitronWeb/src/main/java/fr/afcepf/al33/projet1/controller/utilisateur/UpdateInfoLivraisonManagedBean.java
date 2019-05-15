package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al33.citron.IBusiness.ClientIBusiness;
import fr.afcepf.al33.citron.IBusiness.EntrepotIBusiness;
import fr.afcepf.al33.citron.IBusiness.VilleIBusiness;
import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Ville;



@ManagedBean(name="mbUpdateInfoLivraison")
@SessionScoped
public class UpdateInfoLivraisonManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private ClientIBusiness proxyClient;
	
	@EJB
	private VilleIBusiness proxyVille;
	
	@EJB 
	private EntrepotIBusiness proxyEntrepot; 
	
	@ManagedProperty(value="#{mbConnectionUtilisateur}")
	private ConnectionUtilisateurManagedBean mbConnectionUtilisateur; //avec get/set

	// pour récupération objet client depuis managed bean de l'écran précédent
	//@ManagedProperty(value="#{mbConnectionUtilisateur.clientConnecte}")
	private Client client;
			
	private List<Ville> villes = new ArrayList<Ville>();

	
	@PostConstruct
	public void init() {
		// chargement de toutes les villes
		villes = proxyVille.getAll();
		client = mbConnectionUtilisateur.getClientConnecte();
	}
	
	public void update() throws Exception {
		try {
			// enregistrement des modifications du client
			proxyClient.update(client);
			
			
			// here we have to call our web service livraison 
			System.out.println("================== Start DEBUG======================");
			System.out.println("================== Entrepot ========================");
			System.out.println(proxyEntrepot.searchById(1).getAdresse());
			System.out.println(client.getAdresseLivraison());
			System.out.println("================== Client ==========================");
			System.out.println(client.getId());
			System.out.println(client.getPrenom().toUpperCase().charAt(0));
			System.out.println(client.getNom().toUpperCase().charAt(0));
			System.out.println("================== End DEBUG =======================");
			
			
			//FacesMessage message2 = new FacesMessage(proxyEntrepot.searchById(1).getAdresse());
			// ajout à la liste des messages à afficher
			
			
			
			FacesMessage message = new FacesMessage("MAJ vos infos de Livraison, OK! ");
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			//System.out.println(FacesContext.getCurrentInstance());
			// redirection depuis un managedBean
			FacesContext.getCurrentInstance().getExternalContext().redirect("../interfaceClient/affichageMaFacture.xhtml");
		}
		catch (Exception e) {
			// création d'un message
			FacesMessage message = new FacesMessage("Erreur lors de la MAJ de vos infos de Livraison : " + e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			// ajout à la liste des messages à afficher
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
}

	public ClientIBusiness getProxyClient() {
		return proxyClient;
	}

	public void setProxyClient(ClientIBusiness proxyClient) {
		this.proxyClient = proxyClient;
	}

	public VilleIBusiness getProxyVille() {
		return proxyVille;
	}

	public void setProxyVille(VilleIBusiness proxyVille) {
		this.proxyVille = proxyVille;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public ConnectionUtilisateurManagedBean getMbConnectionUtilisateur() {
		return mbConnectionUtilisateur;
	}

	public void setMbConnectionUtilisateur(ConnectionUtilisateurManagedBean mbConnectionUtilisateur) {
		this.mbConnectionUtilisateur = mbConnectionUtilisateur;
	}
	
	
	
}

