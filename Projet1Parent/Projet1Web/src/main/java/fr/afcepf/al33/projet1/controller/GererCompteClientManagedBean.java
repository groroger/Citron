package fr.afcepf.al33.projet1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.ClientIBusiness;
import fr.afcepf.al33.projet1.IBusiness.VilleIBusiness;
import fr.afcepf.al33.projet1.entity.Client;
import fr.afcepf.al33.projet1.entity.Commande;

@ManagedBean(name="mbGererCompteClient")
@SessionScoped
public class GererCompteClientManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private ClientIBusiness proxyClient;
	
	@EJB
	private VilleIBusiness proxyVille;
		
	private Client client;
	
	@PostConstruct
	public void init() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		// si id dans l'url alors lecture du client en base
		if (params.containsKey("id")) {
			int id = Integer.parseInt(params.get("id").toString());
			try {
				client = proxyClient.searchById(id);
			} catch (Exception e) {
				FacesMessage m = new FacesMessage("Erreur : " + e.getMessage());
				m.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, m);
				e.printStackTrace();
			}
		} else {
			// sinon new Client
			client = new Client();
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
	
	public void ajouter() throws Exception {
		try {
			proxyClient.add(client);
			
			// création d'un message
			FacesMessage message = new FacesMessage("Création de votre compte réussie");
			// ajout à la liste des messages à afficher
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			// redirection depuis un managedBean
			FacesContext.getCurrentInstance().getExternalContext().redirect("accueilClient.xhtml");
		}
		catch (Exception e) {
			// création d'un message
			FacesMessage message = new FacesMessage("Erreur lors de la création de votre compte : " + e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			// ajout à la liste des messages à afficher
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	
	
}
