/**
 * 
 */
package fr.afcepf.al33.citron.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.citron.entity.Entrepot;
import fr.afcepf.al33.citron.entity.Ville;
import fr.afcepf.al33.citron.idao.EntrepotIdao;



/**
 * Add by Amin
 *
 */

@Remote(EntrepotIdao.class)
@Stateless
public class EntrepotDao extends GenericDao<Entrepot> implements EntrepotIdao {
	
	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;

	@Override
	public Entrepot findById(int id) {
		Entrepot entrepot = null;
		
		String REQ_AUTH = "SELECT entrepot from Entrepot entrepot WHERE entrepot.id = :id";	
		Query queryJPQL = em.createQuery(REQ_AUTH);
		queryJPQL.setParameter("id", id);
		entrepot = (Entrepot)queryJPQL.getSingleResult();
		
		return entrepot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entrepot> getAll() {
		List<Entrepot> entrepots = null;
		
		String REQ_GETALL = "SELECT entrepot from Entrepot entrepot";
		Query queryJPQL = em.createQuery(REQ_GETALL);
		entrepots = queryJPQL.getResultList();
		return entrepots;
	}

	@Override
	public Entrepot rechercherParVilleEtCodePostal(String nom, String cp) {
		Entrepot entrepot = null;
		
		/* I need help for this requet ;) 
		String REQ_GETBYNAMEANDBYCP =
				"SELECT ville FROM Ville ville where ville.nom = :nom "
				+ "AND ville.codePostal = :cp";
		*/
		
		return entrepot;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entrepot> getAllByVille(Ville ville) {
		List<Entrepot> entrepots = null;
		
		String REQ = "SELECT entrepot from Entrepot entrepot WHERE entrepot.ville = :ville";
		Query queryJPQL = em.createQuery(REQ);
		queryJPQL.setParameter("ville", ville);
		entrepots = queryJPQL.getResultList();
		
		return entrepots;
	}

	
}
