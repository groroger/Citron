package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import fr.afcepf.al33.citron.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.citron.IBusiness.CategorieIBusiness;
import fr.afcepf.al33.citron.entity.Article;
import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.citron.entity.Categorie;
import fr.afcepf.al33.citron.ws.saison.client.delegate.ClientArticleDelegate;
import fr.afcepf.al33.citron.ws.saison.client.delegate.ClientArticleDelegateSoap;


@ManagedBean(name="mbCatalogueClient")
@SessionScoped
public class CatalogueClientManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantiteSaisie;
	private List <Article> articles;
	private List <Categorie> categories;
	private Categorie selectedCategorie = null;

	private Article selectedArticle;
	private ArticleCommande articleCommande = new ArticleCommande();
	private List<ArticleCommande> articlesCommandes = new ArrayList<ArticleCommande>();

	private List <fr.afcepf.al33.citron.ws.saison.ws.entity.Article> articlesSaison;
	private List <String> libellesArticlesSaison;
	private List<String> saisons;
	private String selectedSaison;


	@EJB
	private ArticleIBusiness proxyArticle;

	@EJB
	private CategorieIBusiness proxyCategorie;


	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		articles=proxyArticle.getAll();
		categories =  proxyCategorie.getAll();
		onCategorieChange();
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		if ((List<ArticleCommande>)session.getAttribute("listeArticlesCommandes")!=null) {
			articlesCommandes= (List<ArticleCommande>)session.getAttribute("listeArticlesCommandes");
		}
		
		// items de la combo box filtre saisonnalité
		saisons = new ArrayList<>();
		saisons.add("Toute saison");
		saisons.add("De saison");
		// liste des articles disponibles pour le mois courant
		articlesSaison = listeArticlesSaison();
		// liste des libellés des articles disponibles pour le mois courant
		libellesArticlesSaison = listeLibellesArticlesSaison(articlesSaison);
		
		// liste de tous les articles connus du web service saison
		List <fr.afcepf.al33.citron.ws.saison.ws.entity.Article> articlesTouteSaison = listeArticlesTouteSaison();
		// liste des libellés de tous les articles connus du web service saison
		List<String> libellesArticlesTouteSaison = listeLibellesArticlesSaison(articlesTouteSaison);
		List<Article> articlesInconnusWebServiceSaison = listeArticlesInconnusWebServiceSaison(articles, libellesArticlesTouteSaison);
		System.out.println("\n*** Articles du catalogue Citron inconnus du web service articles saison ***");
		for (Article article : articlesInconnusWebServiceSaison) {
			System.out.println(article.getNom());
		}
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

		articleCommande = new ArticleCommande();
		articleCommande.setArticle(article);
		articleCommande.setQuantite(article.getQuantiteSaisie());
		Double calculPrixLigneArticleCommande = article.getPrix()*article.getQuantiteSaisie();
		
		DecimalFormat twoDForm =new DecimalFormat("##.##");
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		twoDForm.setDecimalFormatSymbols(dfs);
		calculPrixLigneArticleCommande=Double.parseDouble(twoDForm.format(calculPrixLigneArticleCommande));
		articleCommande.setPrixTotal(calculPrixLigneArticleCommande);
		
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
		
		article.setQuantiteSaisie(0);
		
		System.out.println("Art Quantite "+articleCommande.getQuantite());
		
	
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("listeArticlesCommandes", articlesCommandes);
		facesContext.getApplication()
					.getNavigationHandler()
					.handleNavigation(facesContext,null,"/interfaceClient/catalogueClient.xhtml?faces-redirect=true");

}
	
	public void plusQuantiteSaisie(Article article){	
		article.setQuantiteSaisie(article.getQuantiteSaisie()+1);
}

	public void minusQuantiteSaisie(Article article){
		if (article.getQuantiteSaisie()>0) {
			article.setQuantiteSaisie(article.getQuantiteSaisie()-1);
		}		
}

public void onCategorieChange() {
	updateSelectedArticles();
}

public void onSaisonChange() {
	updateSelectedArticles();
}

public void updateSelectedArticles() {
	
	if (selectedCategorie !=null && !selectedCategorie.equals("") && !selectedCategorie.getNomCategorie().equals("Toutes les catégories")) {
		articles=proxyArticle.getByIdCategorie(selectedCategorie);		
	} else if(selectedCategorie==null) {
		articles=proxyArticle.getAll();	
	} else if(selectedCategorie.getNomCategorie().equals("Toutes les catégories")) {
		articles=proxyArticle.getAll();
	} else {
		articles=new ArrayList<>();
	}	

	// filtre éventuel sur saisonnalité des articles
	// si le webservice est disponible et a fourni une liste d'articles de saison non vide
	if (selectedSaison !=null && selectedSaison.equals("De saison") 
		&& !libellesArticlesSaison.isEmpty()) {
		articles = filtreSaisonFort(articles, libellesArticlesSaison);
	}
}

private List<String> listeLibellesArticlesSaison(List<fr.afcepf.al33.citron.ws.saison.ws.entity.Article> articlesSaison) {
	// liste des libellés des articles de saison pour recherche rapide
	List<String> libellesArticlesSaison = new ArrayList<>();
	for (fr.afcepf.al33.citron.ws.saison.ws.entity.Article articleDeSaison : articlesSaison) {
		libellesArticlesSaison.add(formatRechercheArticle(articleDeSaison.getNom()));
	}
	return libellesArticlesSaison;
}

private List<Article> filtreSaisonFort(List<Article> articles, List<String> libellesArticlesSaison) {
	// filtre des articles sur la saisonnalité
	
	// si le web service est indisponible alors pas de filtre
	if (libellesArticlesSaison.isEmpty())
		return articles;
	
	// liste des articles filtrés
	List<Article> articlesFiltres = new ArrayList<>();
	// pour chaque article
	for (Article article : articles) {
		// rechercher sa présence dans les articles de saison
		// s'il est présent alors l'ajouter à la liste des articles de saison
		// recherche sur les mots en majuscule ramenés au singulier
		if(libellesArticlesSaison.indexOf(formatRechercheArticle(article.getNom())) >= 0) {
			articlesFiltres.add(article);
		}		
	}
	return articlesFiltres;
}

private String formatRechercheArticle(String libelleArticle) {
	// les éléments des noms composés qui peuvent être séparés par des blancs ou des tirets
	List<String> mots = Arrays.asList(libelleArticle.split("[ -]"));
	// sont mis en majuscule
	mots = mots.stream().map(String::toUpperCase).collect(Collectors.toList());
	// sont mis au singulier
	mots = mots.stream().map(mot -> pluralCut(mot)).collect(Collectors.toList());
	// et séparés par un espace
	String libelleArticleFormate = String.join(" ", mots);
	return libelleArticleFormate;
}

public List<fr.afcepf.al33.citron.ws.saison.ws.entity.Article> listeArticlesSaison() {
		
	DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);
	String[] moisFR = dfsFR.getMonths();

	DateTime dateTime = new DateTime(new Date());
	int mois = dateTime.getMonthOfYear();

	List<fr.afcepf.al33.citron.ws.saison.ws.entity.Article> articlesMois = new ArrayList<>();
	// test disponibilité du web service Soap par ClientArticleDelegate
	ClientArticleDelegate clientArticleDelegate = (ClientArticleDelegate)(ClientArticleDelegateSoap.getInstance());
	try {
		articlesMois = clientArticleDelegate.ListeArticlesParMois(mois);

		System.out.println("*** test clientArticleDelegate articles de saison pour le mois de " + moisFR[mois - 1] + " : \n");
		for (fr.afcepf.al33.citron.ws.saison.ws.entity.Article article : articlesMois) {
			System.out.println(article.getNom() + " de " + moisFR[article.getDebutSaison() - 1]
												+ " à " + moisFR[article.getFinSaison() - 1]);
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("web service articles de saison indisponible");
	}

	return articlesMois;
}


public List<fr.afcepf.al33.citron.ws.saison.ws.entity.Article> listeArticlesTouteSaison() {
		
	DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);
	String[] moisFR = dfsFR.getMonths();

	DateTime dateTime = new DateTime(new Date());
	int mois = dateTime.getMonthOfYear();

	List<fr.afcepf.al33.citron.ws.saison.ws.entity.Article> articles = new ArrayList<>();
	// test disponibilité du web service Soap par ClientArticleDelegate
	ClientArticleDelegate clientArticleDelegate = (ClientArticleDelegate)(ClientArticleDelegateSoap.getInstance());
	try {
		articles = clientArticleDelegate.ListeArticles();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("web service articles de saison indisponible");
	}
	return articles;
}

private List<Article> listeArticlesInconnusWebServiceSaison(List<Article> articles, List<String> libellesArticlesTouteSaison) {
	// si le web service est indisponible alors pas de filtre
	if (libellesArticlesSaison.isEmpty())
		return articles;
	
	// liste des articles filtrés
	List<Article> articlesFiltres = new ArrayList<>();
	// pour chaque article
	for (Article article : articles) {
		// rechercher sa présence dans les articles de saison
		// s'il est absent alors l'ajouter à la liste des articles inconnus du web service saison
		// recherche sur les mots en majuscule ramenés au singulier
		if (libellesArticlesTouteSaison.indexOf(formatRechercheArticle(article.getNom())) < 0) {
			articlesFiltres.add(article);
		}		
	}
	return articlesFiltres;
}

private String pluralCut(String name) {
	// supprime les marques françaises de pluriel
	String singleName = name;
	if (singleName.endsWith("s") | singleName.endsWith("S") | singleName.endsWith("x") | singleName.endsWith("X")) {
		if (singleName.length() > 1)
			singleName = singleName.substring(0, singleName.length() - 1);
	}
	return singleName;
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

public List<String> getSaisons() {
	return saisons;
}

public void setSaisons(List<String> saisons) {
	this.saisons = saisons;
}

public String getSelectedSaison() {
	return selectedSaison;
}

public void setSelectedSaison(String saison) {
	this.selectedSaison = saison;
}
}
