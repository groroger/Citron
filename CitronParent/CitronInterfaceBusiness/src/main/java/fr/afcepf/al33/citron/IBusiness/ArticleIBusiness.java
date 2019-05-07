package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Article;
import fr.afcepf.al33.citron.entity.Categorie;

public interface ArticleIBusiness {
	
	List<Article> getAll();
	List<Article> getByIdCategorie(Categorie c);
	public Article update(Article article);
	Article add(Article article);
}
