package fr.afcepf.al33.projet1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fournisseur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Fournisseur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="complementAdresse")
	private String complementAdresse;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Ville ville;
	
	@Column(name="numeroFixe")
	private String numeroFixe;
	
	@Column(name="numeroPort")
	private String numeroPort;
	
	@Column(name="email")
	private String email;

	public Fournisseur() {
		super();
	}

	public Fournisseur(Integer id, String adresse, String complementAdresse, Ville ville, String numeroFixe,
			String numeroPort, String email) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.complementAdresse = complementAdresse;
		this.ville = ville;
		this.numeroFixe = numeroFixe;
		this.numeroPort = numeroPort;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getNumeroFixe() {
		return numeroFixe;
	}

	public void setNumeroFixe(String numeroFixe) {
		this.numeroFixe = numeroFixe;
	}

	public String getNumeroPort() {
		return numeroPort;
	}

	public void setNumeroPort(String numeroPort) {
		this.numeroPort = numeroPort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


}
