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

import fr.afcepf.al33.projet1.IBusiness.ApprovisionnementIBusiness;
import fr.afcepf.al33.projet1.IBusiness.StockIBusiness;
import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.entity.Stock;





@ManagedBean(name="mbAfficherCommande")
@SessionScoped
public class AfficherCommandeManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{mbFicheClient.selectedCommande}")
	private Commande selectedCommande;
	
	private List<ArticleCommande> articlesCommandes = new ArrayList<ArticleCommande>();
	

	

	@PostConstruct
	public void init() {
		articlesCommandes=selectedCommande.getArticlesCommandes();
		
		
		
		for (ArticleCommande articleCommande : articlesCommandes) {
			System.out.println(articleCommande.getArticle().getNom());
		}
	}
	


	public Commande getSelectedCommande() {
		return selectedCommande;
	}



	public void setSelectedCommande(Commande selectedCommande) {
		this.selectedCommande = selectedCommande;
	}




	public List<ArticleCommande> getArticlesCommandes() {
		return articlesCommandes;
	}



	public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
		this.articlesCommandes = articlesCommandes;
	}


}
