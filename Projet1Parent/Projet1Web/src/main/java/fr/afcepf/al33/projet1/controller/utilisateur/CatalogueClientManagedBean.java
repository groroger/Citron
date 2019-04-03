package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Categorie;




@ManagedBean(name="mbCatalogueClient")
@SessionScoped
public class CatalogueClientManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantiteSaisie =1;
	private List <Article> articles;
	private List <Categorie> categories;
	private Categorie selectedCategorie;

	private Article selectedArticle;
	private ArticleCommande articleCommande;
	private List<ArticleCommande> articlesCommandes = new ArrayList<ArticleCommande>();





	@EJB
	private ArticleIBusiness proxyArticle;

	@EJB
	private CategorieIBusiness proxyCategorie;



	@PostConstruct
	public void init() {
		articles= proxyArticle.getAll();

		categories =  proxyCategorie.getAll();

	}

	public void afficherFicheProduit(Article article) {
		selectedArticle = article;

		System.out.println(selectedArticle.getId());

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("selectedArticle", selectedArticle);
		facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceClient/ficheArticleClient.xhtml?faces-redirect=true");
	}

	public void ajouterArticle(Article article) {

		articleCommande =new ArticleCommande();
		articleCommande.setArticle(article);
		articleCommande.setQuantite(quantiteSaisie);
		List<ArticleCommande> articlesCommandesBis = new ArrayList<ArticleCommande>();
		
		
		if (articlesCommandes.isEmpty()){
			articlesCommandes.add(articleCommande);
			System.out.println("ajout premier article");
		} else {
			


			Iterator<ArticleCommande> ite = articlesCommandes.iterator();


			while(ite.hasNext()) {
				ArticleCommande ac = ite.next();
				if (ac.getArticle().getId()==articleCommande.getArticle().getId()) {
					ac.setQuantite(ac.getQuantite()+ quantiteSaisie);
					System.out.println("nombre ajouté à la ligne existante");
				

				} else {
					System.out.println("ajout article autre que le premier");
					articlesCommandesBis.add(articleCommande);
				}
			}
		
		}
		
		articlesCommandes.addAll(articlesCommandesBis);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("listeArticlesCommandes", articlesCommandes);

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

	public int getQuantiteSaisie() {
		return quantiteSaisie;
	}

	public void setQuantiteSaisie(int quantiteSaisie) {
		this.quantiteSaisie = quantiteSaisie;
	}


}
