package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.projet1.entity.Article;
import fr.afcepf.al33.projet1.entity.ArticleCommande;


@ManagedBean(name="mbFicheArticleClient")
@SessionScoped
public class FicheArticleClientManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int quantiteSaisie;

	//@ManagedProperty(value="#{mbCatalogueClient.articleCommande}")
	private ArticleCommande articleCommande;
	
	@ManagedProperty(value="#{mbCatalogueClient.articlesCommandes}")
	List<ArticleCommande> articlesCommandes;

	
	@EJB
	private ArticleIBusiness proxyArticle;
	
	@ManagedProperty(value="#{mbCatalogueClient.selectedArticle}")
	private Article article;
	
	
	@PostConstruct
	public void init() {


		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		article =  (Article) session.getAttribute("selectedArticle");
		
	}

public void ajouterArticle() {
		

		articleCommande =new ArticleCommande();

		articleCommande.setArticle(article);

		articleCommande.setQuantite(article.getQuantiteSaisie());
		
		System.out.println(articleCommande.getArticle().getNom());
		
		boolean isPresent = false;


		if (articlesCommandes.isEmpty()){
			articlesCommandes.add(articleCommande);
			System.out.println("ajout premier article");
		} else {

			Iterator<ArticleCommande> ite = articlesCommandes.iterator();


			while(ite.hasNext()) {
				ArticleCommande ac = ite.next();
				if (ac.getArticle().getId()==articleCommande.getArticle().getId()) {
					ac.setQuantite(ac.getQuantite()+ 1);
					System.out.println("nombre ajouté à la ligne existante");
					isPresent = true;
				}
			} 
			
			if (isPresent == false) {
				articlesCommandes.add(articleCommande);
			}
		}



	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
	session.setAttribute("listeArticlesCommandes", articlesCommandes);
	facesContext.getApplication()
				.getNavigationHandler()
				.handleNavigation(facesContext,null,"/interfaceClient/affichagePanier.xhtml?faces-redirect=true");
	
}

public void plusQuantiteSaisie(){	
	article.setQuantiteSaisie(article.getQuantiteSaisie()+1);

}

public void minusQuantiteSaisie(){
	if (article.getQuantiteSaisie()>0) {
		article.setQuantiteSaisie(article.getQuantiteSaisie()-1);
	}		
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

	public List<ArticleCommande> getArticlesCommandes() {
		return articlesCommandes;
	}

	public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
		this.articlesCommandes = articlesCommandes;
	}

	public ArticleIBusiness getProxyArticle() {
		return proxyArticle;
	}

	public void setProxyArticle(ArticleIBusiness proxyArticle) {
		this.proxyArticle = proxyArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	


	
}
