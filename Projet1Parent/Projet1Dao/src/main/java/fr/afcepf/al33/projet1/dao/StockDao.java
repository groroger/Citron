package fr.afcepf.al33.projet1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.projet1.entity.Stock;
import fr.afcepf.al33.projet1.idao.StockIdao;

@Remote(StockIdao.class)
@Stateless
public class StockDao extends GenericDao<Stock> implements StockIdao {
	
	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getAll() {
		List<Stock>stocks = new ArrayList<Stock>();
		String REQ_GETALL = "SELECT stock from Stock stock";
		Query queryJPQL = em.createQuery(REQ_GETALL);
		stocks = queryJPQL.getResultList();
		return stocks;
		
	}

}
