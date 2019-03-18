package fr.afcepf.al33.projet1.dao;

import java.lang.reflect.ParameterizedType;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al33.projet1.idao.GenericIdao;


@Remote(GenericIdao.class)
@Stateless

public abstract class GenericDao<T> implements GenericIdao<T> {
	
	@PersistenceContext(unitName="Projet1DS")
	private EntityManager em;
	
	
	@Override
	public T ajouter(T t) {

		em.persist(t);
	
		return t;
	}

	@Override
	public boolean supprimer(T t) {

		em.remove(t);

		return true;
	}

	@Override
	public T modifier(T t) {

		em.merge(t);

		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T rechercherParId(Object o) {
		
		System.out.println("Entity Manager Generic: " + em);
		
		T t = null;
		try {


		String className= ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
		Class<?> clazz;
	
			clazz = Class.forName(className);
			t=(T) em.find(clazz, o);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return t;
	}
	


}
