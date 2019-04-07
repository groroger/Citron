package fr.afcepf.al33.projet1.IBusiness;

import java.util.List;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Commande;


public interface ArticleCommandeIBusiness {
	List<ArticleCommande> getAll();
	Commande add(Commande commande, List<ArticleCommande> articlesCommandes);

}
