package fr.afcepf.al33.projet1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personnePhysique")
@PrimaryKeyJoinColumn(name = "id")
public class FournPersonnePhysique extends Fournisseur{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	
	

	public FournPersonnePhysique() {
		super();
		
	}


	public FournPersonnePhysique(Integer id, String adresse, String complementAdresse, Ville ville, String numeroFixe,
			String numeroPort, String email, String nom, String prenom) {
		super(id, adresse, complementAdresse, ville, numeroFixe, numeroPort, email);
		this.nom = nom;
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
