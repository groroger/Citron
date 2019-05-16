package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.citron.delegate.recettes.RecetteDelegate;
import fr.afcepf.al33.citron.delegate.recettes.RecetteDelegateRest;
import fr.afcepf.al33.citron.entity.Article;
import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.dto.IngredientSelectionnee;
import fr.afcepf.al33.dto.RecetteSelectionnee;




@ManagedBean(name="mbCatalogueRecette")
@SessionScoped
public class CatalogueRecetteManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ArticleCommande> articlesCommandes = new ArrayList<ArticleCommande>();

	private List<RecetteSelectionnee> recettes = new ArrayList<RecetteSelectionnee>();
	
	private RecetteDelegate recetteDelegate = new RecetteDelegateRest();
	
	private RecetteSelectionnee selectedRecette;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {

		List<String> listeArticle = new ArrayList<String>();
		
		System.out.println("coucou 1");
		
		// chargement de la table des articles commandés (panier)
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		
		if ((List<ArticleCommande>)session.getAttribute("listeArticlesCommandes")!=null) {
			articlesCommandes= (List<ArticleCommande>)session.getAttribute("listeArticlesCommandes");
			for (ArticleCommande articleCommande : articlesCommandes)
			{
				listeArticle.add(articleCommande.getArticle().getNom());
			}
			
		}
		System.out.println("listeArticle = "+listeArticle);		
		recettes = recetteDelegate.recettesSelectionnees(listeArticle);
		for (RecetteSelectionnee recetteSelectionnee : recettes) 
		{
			System.out.println("recetteSelectionnee = "+recetteSelectionnee.toString());
		}
		
		System.out.println("coucou 2");
	}

	public void afficherFicheRecette(RecetteSelectionnee recette) {
		
		System.out.println(recette.getNom());

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("selectedRecette", recette);
		facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceClient/ficheRecette.xhtml?faces-redirect=true");
	}

	public String listeIngredient(RecetteSelectionnee recette) {
		String listeIngredient = "";
		List<IngredientSelectionnee> ingredientSelectionnees = recette.getIngredientSelectionnees();
		for (IngredientSelectionnee ingSel: ingredientSelectionnees) 
		{
			listeIngredient = listeIngredient+ingSel.getNom()+", ";
		} 
		
		System.out.println("listeIngredient = "+listeIngredient);
		listeIngredient = listeIngredient.substring(0, listeIngredient.length()-1);
		listeIngredient = listeIngredient.substring(0, listeIngredient.length()-1);
		listeIngredient = listeIngredient+".";
		
		return listeIngredient;
	}

	public String afficherImage(RecetteSelectionnee recette) {
		// l'URL où se trouve les images dans le Web service est une variable à récupérer dans le fichier application.properties
		ResourceBundle ressources = ResourceBundle.getBundle("param") ; // accès à application.properties 
		String urlImages = ressources.getString("urlImages");
		urlImages = urlImages+recette.getImageMini();
				
		return urlImages;
	}

public List<ArticleCommande> getArticlesCommandes() {
	return articlesCommandes;
}

public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
	this.articlesCommandes = articlesCommandes;
}

public List<RecetteSelectionnee> getRecettes() {
	return recettes;
}

public RecetteSelectionnee getSelectedRecette() {
	return selectedRecette;
}

public void setSelectedRecette(RecetteSelectionnee selectedRecette) {
	this.selectedRecette = selectedRecette;
}



}
