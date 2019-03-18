package fr.afcepf.al33.projet1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personneMorale")
@PrimaryKeyJoinColumn(name = "id")
public class FournPersonneMorale extends Fournisseur{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="denomination")
	private String denomination;
	
	

	public FournPersonneMorale() {
		super();
	}



	public FournPersonneMorale(Integer id, String adresse, String complementAdresse, Ville ville, String numeroFixe,
			String numeroPort, String email, String denomination) {
		super(id, adresse, complementAdresse, ville, numeroFixe, numeroPort, email);
		this.denomination = denomination;
		
	}



	public String getDenomination() {
		return denomination;
	}



	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	
	
}
