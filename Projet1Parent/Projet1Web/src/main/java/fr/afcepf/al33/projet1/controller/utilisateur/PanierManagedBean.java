package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.entity.Article;
import fr.afcepf.al33.projet1.entity.ArticleCommande;




@ManagedBean(name="mbPanier")
@SessionScoped
public class PanierManagedBean implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @ManagedProperty(value="#{mbCatalogueClient.articlesCommandes}")
  private List<ArticleCommande> articlesCommandes;
  
  @ManagedProperty(value="#{mbCatalogueClient.quantiteSaisie}")
  private int quantiteSaisie;
  
  private ArticleCommande articleCommande;
  private Article selectedArticle;
  
//  public void afficherFicheProduit(Article article) {
//		selectedArticle = article;
//
//		System.out.println(selectedArticle.getId());
//
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
//		session.setAttribute("selectedArticle", selectedArticle);
//		facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceClient/ficheArticleClient.xhtml?faces-redirect=true");
//	}
  
  public void ajouterArticle(Article article) {

		articleCommande = new ArticleCommande();
		articleCommande.setArticle(article);
		articleCommande.setQuantite(article.getQuantiteSaisie());
		boolean isPresent = false;


		if (articlesCommandes.isEmpty()){
			articlesCommandes.add(articleCommande);
			System.out.println("ajout premier article");
		} else {

			Iterator<ArticleCommande> ite = articlesCommandes.iterator();


			while(ite.hasNext()) {
				ArticleCommande ac = ite.next();
				if (ac.getArticle().getId()==articleCommande.getArticle().getId()) {
					ac.setQuantite(ac.getQuantite()+ article.getQuantiteSaisie());
					System.out.println("nombre ajouté à la ligne existante");
					isPresent = true;
				}
			} 
			
			if (isPresent == false) {
				articlesCommandes.add(articleCommande);
			}
		}
		
		System.out.println("Art Quantite "+articleCommande.getQuantite());
		
	
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("listeArticlesCommandes", articlesCommandes);
		facesContext.getApplication()
					.getNavigationHandler()
					.handleNavigation(facesContext,null,"/interfaceClient/affichagePanier.xhtml?faces-redirect=true");

}
	
	public void plusQuantiteSaisie(Article article){	
		article.setQuantiteSaisie(article.getQuantiteSaisie()+1);
}

	public void minusQuantiteSaisie(Article article){
		if (article.getQuantiteSaisie()>0) {
			article.setQuantiteSaisie(article.getQuantiteSaisie()-1);
		}		
}
  
  
  public List<ArticleCommande> getArticlesCommandes() {
    return articlesCommandes;
  }



  public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
    this.articlesCommandes = articlesCommandes;
  }



  public int getQuantiteSaisie() {
    return quantiteSaisie;
  }



  public void setQuantiteSaisie(int quantiteSaisie) {
    this.quantiteSaisie = quantiteSaisie;
  }

public ArticleCommande getArticleCommande() {
	return articleCommande;
}

public void setArticleCommande(ArticleCommande articleCommande) {
	this.articleCommande = articleCommande;
}

public Article getSelectedArticle() {
	return selectedArticle;
}

public void setSelectedArticle(Article selectedArticle) {
	this.selectedArticle = selectedArticle;
}


}