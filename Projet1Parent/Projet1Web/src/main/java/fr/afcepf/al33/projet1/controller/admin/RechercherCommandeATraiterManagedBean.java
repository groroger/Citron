package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.projet1.entity.Commande;


@ManagedBean(name="mbFindCommandeATraiter")
@SessionScoped
public class RechercherCommandeATraiterManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private CommandeIBusiness proxyCommande;
	
	private Commande foundCommande;
	private List<Commande> commandes;

	

	
	public void onSelect(Commande cde) {
	
		foundCommande = cde;
	  		
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		 HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		 session.setAttribute("foundCommande", foundCommande);
		 facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceAdmin/ficheCommande.xhtml?faces-redirect=true");
	}
	
	
	@PostConstruct
	public void init() {
		commandes = proxyCommande.getAllToProcess();
		
	}


	public CommandeIBusiness getProxyCommande() {
		return proxyCommande;
	}


	public void setProxyCommande(CommandeIBusiness proxyCommande) {
		this.proxyCommande = proxyCommande;
	}


	public Commande getFoundCommande() {
		return foundCommande;
	}


	public void setFoundCommande(Commande foundCommande) {
		this.foundCommande = foundCommande;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	// formatage date commande
	public String getDateToString(Date date) {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
												DateFormat.SHORT,
												DateFormat.SHORT);
		
        return shortDateFormat.format(date);
    }
}
