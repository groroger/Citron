package fr.afcepf.al33.projet1.dao;

import java.time.LocalDate;
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
	public List<Approvisionnement> getAllApproByStock(Stock stock) {
		List<Approvisionnement> approvisionnements = null;
		String REQ = "SELECT approvisionnement from Approvisionnement approvisionnement WHERE approvisionnement.stock.id = :id";
		Query queryJPQL = em.createQuery(REQ);
		queryJPQL.setParameter("id", stock.getId());
		approvisionnements = queryJPQL.getResultList();
		return approvisionnements;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Approvisionnement> getOutOfDateAppro(int nbJours) {
		// retourne la liste des approvisionnements
		// avec date de péremption proche de la date du jour
				
		List<Approvisionnement> approvisionnements = null;
		java.sql.Date dateButoire;
		dateButoire = java.sql.Date.valueOf(LocalDate.now().plusDays(nbJours));
		String REQ = "SELECT appro from Approvisionnement appro inner join Article art on appro.article = art.id WHERE appro.datePeremption <= :date";
		Query queryJPQL = em.createQuery(REQ);
		queryJPQL.setParameter("date", dateButoire);
		approvisionnements = queryJPQL.getResultList();
		return approvisionnements;
		
	}
	
}
