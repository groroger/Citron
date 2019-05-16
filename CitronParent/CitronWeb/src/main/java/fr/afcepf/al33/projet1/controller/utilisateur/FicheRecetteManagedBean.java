package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.citron.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.citron.entity.Article;
import fr.afcepf.al33.citron.entity.ArticleCommande;
import fr.afcepf.al33.dto.EtapeRecetteSelectionnee;
import fr.afcepf.al33.dto.IngredientSelectionnee;
import fr.afcepf.al33.dto.RecetteSelectionnee;


@ManagedBean(name="mbFicheRecette")
@SessionScoped
public class FicheRecetteManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<IngredientSelectionnee> ingredientSelectionnees; 
	private List<EtapeRecetteSelectionnee> etapeRecetteSelectionnees;
	
	
	@ManagedProperty(value="#{mbCatalogueRecette.selectedRecette}")
	private RecetteSelectionnee recette;
	
	

	@PostConstruct
	public void init() {


		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		
		recette =  (RecetteSelectionnee) session.getAttribute("selectedRecette");
		ingredientSelectionnees = recette.getIngredientSelectionnees();
		etapeRecetteSelectionnees = recette.getEtapeRecetteSelectionnees();
		
		
	}


	public List<IngredientSelectionnee> getIngredientSelectionnees() {
		return ingredientSelectionnees;
	}

	public void setIngredientSelectionnees(List<IngredientSelectionnee> ingredientSelectionnees) {
		this.ingredientSelectionnees = ingredientSelectionnees;
	}

	public List<EtapeRecetteSelectionnee> getEtapeRecetteSelectionnees() {
		return etapeRecetteSelectionnees;
	}

	public void setEtapeRecetteSelectionnees(List<EtapeRecetteSelectionnee> etapeRecetteSelectionnees) {
		this.etapeRecetteSelectionnees = etapeRecetteSelectionnees;
	}

	public RecetteSelectionnee getRecette() {
		return recette;
	}

	public void setRecette(RecetteSelectionnee recette) {
		this.recette = recette;
	}

	

}
