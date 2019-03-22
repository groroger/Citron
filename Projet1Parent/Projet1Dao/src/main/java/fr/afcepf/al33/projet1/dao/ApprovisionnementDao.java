package fr.afcepf.al33.projet1.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.idao.ApprovisionnementIdao;


@Remote(ApprovisionnementIdao.class)
@Stateless
public class ApprovisionnementDao extends GenericDao<Approvisionnement> implements ApprovisionnementIdao {

	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;
}
