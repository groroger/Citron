package fr.afcepf.al33.projet1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.ClientIBusiness;
import fr.afcepf.al33.projet1.entity.Client;
import fr.afcepf.al33.projet1.entity.Commande;




@ManagedBean(name="mbFicheClient")
@SessionScoped
public class FicheClientManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ClientIBusiness proxyClient;
	
	
	@ManagedProperty(value="#{mbFindClient.foundClient}")
	private Client client;
	
	List<Commande> commandes= new ArrayList<Commande>();

	
	
	

	@PostConstruct
	public void init() {


		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		client = (Client) session.getAttribute("foundClient");
		
		commandes= client.getCommandes();
		
	
	}
	


	public ClientIBusiness getProxyClient() {
		return proxyClient;
	}




	public void setProxyClient(ClientIBusiness proxyClient) {
		this.proxyClient = proxyClient;
	}




	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}



	public List<Commande> getCommandes() {
		return commandes;
	}



	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
	
}
