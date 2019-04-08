package fr.afcepf.al33.projet1.idao;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Article;
import fr.afcepf.al33.projet1.entity.ArticleCommande;

public interface ArticleCommandeIDao extends GenericIdao<ArticleCommande> {
	
	List<ArticleCommande> getAll();

}
