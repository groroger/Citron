package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Commande;


@ManagedBean(name="mbMaFacture")
@SessionScoped
public class MaFactureManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{mbConnectionUtilisateur.clientConnecte}")
	private Client client;
	

	@PostConstruct
	public void init() {
		
	}
	
	public void valider() {
		System.out.println("=================================================================");
		System.out.println(client.getAdresseLivraison());
		System.out.println(client.toString());
		
		System.out.println("=================================================================");
	}
	
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
