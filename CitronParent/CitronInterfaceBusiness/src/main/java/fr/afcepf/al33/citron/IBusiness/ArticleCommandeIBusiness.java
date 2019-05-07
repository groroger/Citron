package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.citron.entity.Commande;


public interface ArticleCommandeIBusiness {
	List<ArticleCommande> getAllByCommande(Commande commande);
	Commande add(Commande commande, List<ArticleCommande> articlesCommandes);

} 
