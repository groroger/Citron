package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Categorie;



public interface CategorieIdao extends GenericIdao<Categorie> {


	List<Categorie> getAll();


	
}
