package fr.afcepf.al33.projet1.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.projet1.entity.Ville;
import fr.afcepf.al33.projet1.idao.VilleIdao;



@Remote(VilleIdao.class)
@Stateless
public class VilleDao extends GenericDao<Ville> implements VilleIdao {
	
	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;



		@SuppressWarnings("unchecked")
		@Override
		public List<Ville> getAll() {
			List<Ville> villes = null;
			String REQ_GETALL = "SELECT ville from Ville ville";
			Query queryJPQL = em.createQuery(REQ_GETALL);
			villes = queryJPQL.getResultList();
			return villes;
		}
		
	}

	
	

