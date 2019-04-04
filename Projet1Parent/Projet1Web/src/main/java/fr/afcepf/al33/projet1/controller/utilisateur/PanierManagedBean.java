package fr.afcepf.al33.projet1.controller.utilisateur;
//
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


import fr.afcepf.al33.projet1.entity.ArticleCommande;




@ManagedBean(name="mbPanier")
@SessionScoped
public class PanierManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManagedProperty(value="#{mbCatalogueClient.articlesCommandes}")
	private List<ArticleCommande> articlesCommandes ;
	




	public List<ArticleCommande> getArticlesCommandes() {
		return articlesCommandes;
	}



	public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
		this.articlesCommandes = articlesCommandes;
	}





}
