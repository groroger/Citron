package fr.afcepf.al33.projet1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="approvisionnement")
public class Approvisionnement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	

	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Article article;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Fournisseur fournisseur;
	
	@Column(name="quantite")
	private int quantite;
	
	@Column(name="prix")
	private double prix;
	
	@Column(name="dateApprovisionnement")
	private Date dateApprovisionnement;
	
	@Column(name="lot")
	private String lot;
	

	public Approvisionnement() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public Date getDateApprovisionnement() {
		return dateApprovisionnement;
	}


	public void setDateApprovisionnement(Date dateApprovisionnement) {
		this.dateApprovisionnement = dateApprovisionnement;
	}


	public String getLot() {
		return lot;
	}


	public void setLot(String lot) {
		this.lot = lot;
	}
	
}
