package fr.afcepf.al33.projet1.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.idao.CommandeIdao;


@Remote(CommandeIdao.class)
@Stateless
public class CommandeDao extends GenericDao<Commande> implements CommandeIdao {

	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Commande> getAll() {
		List<Commande> commandes=null;
		String REQ = "SELECT commande from Commande commande ORDER BY commande.id";
		Query queryJPQL = em.createQuery(REQ);
		commandes = queryJPQL.getResultList();
		return commandes;
	}

	@SuppressWarnings("unchecked")
	public List<Commande> getAllToProcess() {
		List<Commande> commandes = null;
		// Commande à traiter si dateExpedition = null
		String REQ = "SELECT commande from Commande commande WHERE commande.dateExpedition = null ORDER BY commande.dateCreation";
		Query queryJPQL = em.createQuery(REQ);
		commandes = queryJPQL.getResultList();
		return commandes;
		
	}
}
