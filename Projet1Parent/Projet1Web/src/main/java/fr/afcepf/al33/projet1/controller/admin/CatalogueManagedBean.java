package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.projet1.IBusiness.CategorieIBusiness;
import fr.afcepf.al33.projet1.entity.Article;
import fr.afcepf.al33.projet1.entity.Categorie;



@ManagedBean(name="mbCatalogue")
@SessionScoped
public class CatalogueManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private List <Article> articles;
	private List <Categorie> categories;
	private Categorie selectedCategorie;

	private Article selectedArticle;


	@EJB
	private ArticleIBusiness proxyArticle;

	@EJB
	private CategorieIBusiness proxyCategorie;



	@PostConstruct
	public void init() {
		articles= proxyArticle.getAll();

		categories =  proxyCategorie.getAll();

	}

	public void afficherFichePorduit(Article article) {
		selectedArticle = article;

		System.out.println(selectedArticle.getId());

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("selectedArticle", selectedArticle);
		facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceAdmin/ficheArticleAdmin.xhtml?faces-redirect=true");
	}


	public void onCategorieChange() {


		if (selectedCategorie !=null && !selectedCategorie.equals("") && !selectedCategorie.getNomCategorie().equals("Toutes les catégories")) {
			
			articles=proxyArticle.getByIdCategorie(selectedCategorie);
			
		} else if(selectedCategorie.getNomCategorie().equals("Toutes les catégories")) {
			
			articles=proxyArticle.getAll();

		} else {
			
			articles=new ArrayList<>();
			
		}
	}


	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public Article getSelectedArticle() {
		return selectedArticle;
	}

	public void setSelectedArticle(Article selectedArticle) {
		this.selectedArticle = selectedArticle;
	}

	public ArticleIBusiness getProxyArticle() {
		return proxyArticle;
	}

	public void setProxyArticle(ArticleIBusiness proxyArticle) {
		this.proxyArticle = proxyArticle;
	}

	public CategorieIBusiness getProxyCategorie() {
		return proxyCategorie;
	}

	public void setProxyCategorie(CategorieIBusiness proxyCategorie) {
		this.proxyCategorie = proxyCategorie;
	}

}
