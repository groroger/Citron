package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.citron.entity.Commande;

public interface ArticleCommandeIDao extends GenericIdao<ArticleCommande> {
	
	List<ArticleCommande> getAllByCommande(Commande commande);

}
