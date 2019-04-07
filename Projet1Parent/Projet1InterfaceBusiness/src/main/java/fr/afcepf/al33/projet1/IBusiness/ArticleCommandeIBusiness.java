package fr.afcepf.al33.projet1.IBusiness;

import java.util.List;
import fr.afcepf.al33.projet1.entity.ArticleCommande;


public interface ArticleCommandeIBusiness {
	List<ArticleCommande> getAll();
	ArticleCommande add(ArticleCommande articleCommande);

}
