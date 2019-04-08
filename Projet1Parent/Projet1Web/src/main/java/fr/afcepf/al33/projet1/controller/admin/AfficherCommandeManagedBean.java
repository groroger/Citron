package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.ArticleCommandeIBusiness;
import fr.afcepf.al33.projet1.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Commande;


@ManagedBean(name="mbAfficherCommande")
@SessionScoped
public class AfficherCommandeManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{mbFicheClient.selectedCommande}")
	private Commande commande;
	
	private List<ArticleCommande> articlesCommandes = new ArrayList<ArticleCommande>();
	
	private Date dateTraitement = new Date();
	
	@EJB
	private CommandeIBusiness proxyCommande;
	
	@EJB
	private ArticleCommandeIBusiness proxyArticleCommande;

	@PostConstruct
	public void init() {
	
		
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		commande = (Commande) session.getAttribute("selectedCommande");
		
		articlesCommandes=proxyArticleCommande.getAllByCommande(commande);
	}
	
	public void traiterCommande() {
		if(commande.getDateExpedition()==null) {
			commande.setDateExpedition(dateTraitement);
			proxyCommande.update(commande);
			System.out.println("commande traitée!");
		}
		
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		 facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceAdmin/ficheClient.xhtml?faces-redirect=true");
	}
	


	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	public List<ArticleCommande> getArticlesCommandes() {
		return articlesCommandes;
	}



	public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
		this.articlesCommandes = articlesCommandes;
	}

	public Date getDateTraitement() {
		return dateTraitement;
	}

	public void setDateTraitement(Date dateTraitement) {
		this.dateTraitement = dateTraitement;
	}

	public CommandeIBusiness getProxyCommande() {
		return proxyCommande;
	}

	public void setProxyCommande(CommandeIBusiness proxyCommande) {
		this.proxyCommande = proxyCommande;
	}

	

}
