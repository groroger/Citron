package fr.afcepf.al33.projet1.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.projet1.IBusiness.ArticleCommandeIBusiness;
import fr.afcepf.al33.projet1.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.idao.ArticleCommandeIDao;


@Remote(ArticleCommandeIBusiness.class)
@Stateless
public class ArticleCommandeBusiness implements ArticleCommandeIBusiness {

	@EJB
	private ArticleCommandeIDao proxyArticleCommandeIDao;
	
	@Override
	public List<ArticleCommande> getAll() {
		List<ArticleCommande> articlesCommandes = proxyArticleCommandeIDao.getAll();
		return articlesCommandes;
	}
	
	@Override
	public ArticleCommande add(ArticleCommande articleCommande) {
		return proxyArticleCommandeIDao.ajouter(articleCommande);
		
	}

}
