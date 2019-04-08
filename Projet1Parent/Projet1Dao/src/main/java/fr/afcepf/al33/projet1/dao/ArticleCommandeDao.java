package fr.afcepf.al33.projet1.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.idao.ArticleCommandeIDao;


@Remote(ArticleCommandeIDao.class)
@Stateless
public class ArticleCommandeDao extends GenericDao<ArticleCommande> implements ArticleCommandeIDao{
	
	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleCommande> getAll() {
		List<ArticleCommande> articlesCommandes=null;
		String REQ = "SELECT ac from ArticleCommande ac ORDER BY ac.article.nom";
		Query queryJPQL = em.createQuery(REQ);
		articlesCommandes = queryJPQL.getResultList();
		return articlesCommandes;
	}

	
}
