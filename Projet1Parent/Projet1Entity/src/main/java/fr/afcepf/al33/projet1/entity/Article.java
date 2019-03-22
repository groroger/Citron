package fr.afcepf.al33.projet1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article implements Serializable{

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
	
	@Column(name="descriptif")
	private String descriptif;
	
	@Column(name="image")
	private String image;
	
	@Column(name="quantiteVendueKg")
	private double quantiteVendueKg;
	
	@Column(name="prix")
	private double prix;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Categorie categorie;

	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private Stock stock;
	
	@OneToMany(mappedBy="article", cascade=CascadeType.ALL)
	private List<Commande> commandes;
	      
	@OneToMany(mappedBy="article", cascade=CascadeType.ALL)
	private List<Approvisionnement> approvisionnements;
	

	
	public Article() {
		super();
	}



	public Article(Integer id, String nom, String descriptif, String image, double quantiteVendueKg, double prix,
			Categorie categorie, Stock stock, List<Commande> commandes, List<Approvisionnement> approvisionnements) {
		super();
		this.id = id;
		this.nom = nom;
		this.descriptif = descriptif;
		this.image = image;
		this.quantiteVendueKg = quantiteVendueKg;
		this.prix = prix;
		this.categorie = categorie;
		this.stock = stock;
		this.commandes = commandes;
		this.approvisionnements = approvisionnements;
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


	public String getDescriptif() {
		return descriptif;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}



	public double getQuantiteVendueKg() {
		return quantiteVendueKg;
	}



	public void setQuantiteVendueKg(double quantiteVendueKg) {
		this.quantiteVendueKg = quantiteVendueKg;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	public List<Approvisionnement> getApprovisionnements() {
		return approvisionnements;
	}


	public void setApprovisionnements(List<Approvisionnement> approvisionnements) {
		this.approvisionnements = approvisionnements;
	}

}
