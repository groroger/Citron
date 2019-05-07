package fr.afcepf.al33.citron.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.citron.IBusiness.ArticleCommandeIBusiness;
import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.citron.entity.Commande;
import fr.afcepf.al33.citron.idao.ArticleCommandeIDao;
import fr.afcepf.al33.citron.idao.CommandeIdao;


@Remote(ArticleCommandeIBusiness.class)
@Stateless
public class ArticleCommandeBusiness implements ArticleCommandeIBusiness {

	@EJB
	private ArticleCommandeIDao proxyArticleCommandeIDao;
	
	@EJB
	private CommandeIdao proxyCommandeIDao;
	
	@Override
	public List<ArticleCommande> getAllByCommande(Commande commande) {
		List<ArticleCommande> articlesCommandes = proxyArticleCommandeIDao.getAllByCommande(commande);
		return articlesCommandes;
	}
	 
	@Override
	public Commande add(Commande commande, List<ArticleCommande> articlesCommandes) {
		Commande cmde = proxyCommandeIDao.ajouter(commande);
		for (ArticleCommande articleCmde: articlesCommandes) {
			articleCmde.setCommande(cmde);
			proxyArticleCommandeIDao.ajouter(articleCmde);
		}
		return cmde;
		
	}
	
	

}
