package fr.afcepf.al33.projet1.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.projet1.IBusiness.ArticleCommandeIBusiness;
import fr.afcepf.al33.projet1.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.idao.ArticleCommandeIDao;
import fr.afcepf.al33.projet1.idao.CommandeIdao;


@Remote(ArticleCommandeIBusiness.class)
@Stateless
public class ArticleCommandeBusiness implements ArticleCommandeIBusiness {

	@EJB
	private ArticleCommandeIDao proxyArticleCommandeIDao;
	
	@EJB
	private CommandeIdao proxyCommandeIDao;
	
	@Override
	public List<ArticleCommande> getAll() {
		List<ArticleCommande> articlesCommandes = proxyArticleCommandeIDao.getAll();
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
