package fr.afcepf.al33.citron.ws.saison.client.delegate;

import java.util.List;

import fr.afcepf.al33.citron.ws.saison.client.dto.ArticleDto;
import fr.afcepf.al33.citron.ws.saison.client.dto.CategorieDto;


// cette interface sera impl�ment�e par:
//		AdminArticleDelegateSoap
// ou 	AdminArticleDelegateRest

public interface AdminArticleDelegate {
	CategorieDto 		categorieParId(int id);
	List<CategorieDto> 	listeCategories();
	CategorieDto 		sauvegarderCategorie(CategorieDto categorie);
	void				supprimerCategorieParId(int id);
	
	ArticleDto 			articleParId(int id);
	List<ArticleDto> 	listeArticles();
	ArticleDto 			sauvegarderArticle(ArticleDto article);
	void				supprimerArticleParId(int id);
}
