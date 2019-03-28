package fr.afcepf.al33.projet1.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.Stock;
import fr.afcepf.al33.projet1.idao.ApprovisionnementIdao;


@Remote(ApprovisionnementIdao.class)
@Stateless
public class ApprovisionnementDao extends GenericDao<Approvisionnement> implements ApprovisionnementIdao {

	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Approvisionnement> getAllApproByIdArticle(Stock stock) {
		List<Approvisionnement> approvisionnements = null;
		String REQ = "SELECT approvisionnement from Approvisionnement approvisionnement WHERE approvisionnement.stock_id = :id";
		Query queryJPQL = em.createQuery(REQ);
		queryJPQL.setParameter("id", stock.getId());
		approvisionnements = queryJPQL.getResultList();
		return approvisionnements;
		
	}
}
