package fr.afcepf.al33.citron.delegate.recettes;

import java.util.List;

import fr.afcepf.al33.dto.RecetteSelectionnee;

public interface RecetteDelegate {
	
	List<RecetteSelectionnee> recettesSelectionnees(List<String> listeArticle);
	
}
