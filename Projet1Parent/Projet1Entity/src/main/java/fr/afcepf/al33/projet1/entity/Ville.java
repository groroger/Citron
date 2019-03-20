package fr.afcepf.al33.projet1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ville")
public class Ville implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="codePostal")
	private String codePostal;
	
	@OneToMany(mappedBy="ville", cascade=CascadeType.ALL)
	private List<Client> clients;
	
	@OneToMany(mappedBy="ville", cascade=CascadeType.ALL)
	private List<Fournisseur> fournisseurs;

	
	
	
	public Ville() {
		super();
		
	}




	public Ville(Integer id, String nom, String codePostal, List<Client> clients, List<Fournisseur> fournisseurs) {
		super();
		this.id = id;
		this.nom = nom;
		this.codePostal = codePostal;
		this.clients = clients;
		this.fournisseurs = fournisseurs;
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	public List<Client> getClients() {
		return clients;
	}



	public void setClients(List<Client> clients) {
		this.clients = clients;
	}



	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}




	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	
	
	
}
