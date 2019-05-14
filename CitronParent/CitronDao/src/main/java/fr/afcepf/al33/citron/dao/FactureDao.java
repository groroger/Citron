package fr.afcepf.al33.citron.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Facture;
import fr.afcepf.al33.citron.idao.FactureIdao;

@Remote(FactureIdao.class)
@Stateless
public class FactureDao implements FactureIdao {

	@PersistenceContext(unitName = "Projet1DS")
	private EntityManager em;

	@Override
	public Facture ajouter(Facture t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimer(Facture t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Facture modifier(Facture t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture rechercherParId(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Facture> getAll() {
		List<Facture> factures = null;
		String REQ = "SELECT facture from Facture facture ORDER BY facture.id";
		Query queryJPQL = em.createQuery(REQ);
		factures = queryJPQL.getResultList();
		return factures;
	}

	@SuppressWarnings("unchecked")
	public List<Facture> getAllToProcess() {
		// slf4jLogger.debug("getAllToProcess");
		List<Facture> factures = null;
		// Facture à traiter si dateExpedition = null
		String REQ = "SELECT facture from Facture facture WHERE facture.dateExpedition is null ORDER BY facture.dateCreation desc";
		Query queryJPQL = em.createQuery(REQ);
		factures = queryJPQL.getResultList();
		return factures;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facture> getAllByClient(Client client) {
		List<Facture> factures = null;
		String REQ = "SELECT facture from Facture facture WHERE facture.client = :client ORDER BY facture.dateCreation desc";
		Query queryJPQL = em.createQuery(REQ);
		queryJPQL.setParameter("client", client);
		factures = queryJPQL.getResultList();
		return factures;
	}

}
