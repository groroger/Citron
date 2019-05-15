package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al33.citron.bd.panierSaisonWS.PanierSaisonBusiness;
import fr.afcepf.al33.citron.bd.panierSaisonWS.data.RefPanier;

@ManagedBean(name="mbPanierSaison")
@SessionScoped
public class PanierSaisonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoriePanier;
	
	private double prixPanier;
	
	private PanierSaisonBusiness panierSaison;
	
	public void genererPanierSaison(double prixPanier, String categoriePanier)
	{
		List<RefPanier> listarticles = panierSaison.getPanier(categoriePanier, prixPanier);
		
		for (RefPanier refPanier : listarticles) {
			System.out.println("article n°"+refPanier.getId().toString()+" = "+refPanier.getQuantite().toString());
		}
	}

	public String getCategoriePanier() {
		return categoriePanier;
	}

	public void setCategoriePanier(String categoriePanier) {
		this.categoriePanier = categoriePanier;
	}

	public double getPrixPanier() {
		return prixPanier;
	}

	public void setPrixPanier(double prixPanier) {
		this.prixPanier = prixPanier;
	}

}
