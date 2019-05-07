package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Article;
import fr.afcepf.al33.citron.entity.Categorie;

public interface ArticleIdao extends GenericIdao<Article>{

	
	List<Article> getAll();
	List<Article> getByIdCategorie(Categorie c);
	
}
