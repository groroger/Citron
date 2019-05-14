package fr.afcepf.al33.citron.ws.saison.client.delegate;

import java.util.List;

import fr.afcepf.al33.citron.ws.saison.ws.entity.Article;
import fr.afcepf.al33.citron.ws.saison.ws.entity.Categorie;

// cette interface sera impl�ment�e par:
//		ClientArticleDelegateSoap
// ou 	ClientArticleDelegateRest

public interface ClientArticleDelegate {
	List<Categorie> ListeCategories();
	List<Article> ListeArticles();
	List<Article> ListeArticlesParCategorie(Categorie categorie);
	List<Article> ListeArticlesParCategorieEtMois(Categorie categorie, int mois);
	List<Article> ListeArticlesParMois(int mois);
	List<Article> ListeArticlesParNom(String nom);
}
