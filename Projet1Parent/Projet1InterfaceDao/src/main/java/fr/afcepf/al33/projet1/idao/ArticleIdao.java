package fr.afcepf.al33.projet1.idao;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Article;

public interface ArticleIdao extends GenericIdao<Article>{

	
	List<Article> getAll();
//TODO	List<Fourniture> getByIdCategorie(Categorie c);
	
}
