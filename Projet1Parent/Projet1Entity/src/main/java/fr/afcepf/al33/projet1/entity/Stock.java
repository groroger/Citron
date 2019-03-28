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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	
	@OneToOne(mappedBy = "stock")
	private Article article;
	
	@Column(name="quantiteDispoSiteInternet")
	private int quantiteDispoSiteInternet;
	
	@Column(name="quantiteDispoPhysique")
	private int quantiteDispoPhysique;
	
	@OneToMany(mappedBy="Stock", cascade=CascadeType.ALL)
	private List<Approvisionnement> approvisionnement;

	
	//Constructeur vide
	
	public Stock() {
		super();

	}
	
	//Constructeur chargé

	public Stock(Integer id, Article article, int quantiteDispoSiteInternet, int quantiteDispoPhysique,
			List<Approvisionnement> approvisionnement) {
		super();
		this.id = id;
		this.article = article;
		this.quantiteDispoSiteInternet = quantiteDispoSiteInternet;
		this.quantiteDispoPhysique = quantiteDispoPhysique;
		this.approvisionnement = approvisionnement;
	}

	
	//GETTERS ET SETTERS

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


	public int getQuantiteDispoSiteInternet() {
		return quantiteDispoSiteInternet;
	}


	public void setQuantiteDispoSiteInternet(int quantiteDispoSiteInternet) {
		this.quantiteDispoSiteInternet = quantiteDispoSiteInternet;
	}


	public int getQuantiteDispoPhysique() {
		return quantiteDispoPhysique;
	}


	public void setQuantiteDispoPhysique(int quantiteDispoPhysique) {
		this.quantiteDispoPhysique = quantiteDispoPhysique;
	}


	public List<Approvisionnement> getApprovisionnement() {
		return approvisionnement;
	}


	public void setApprovisionnement(List<Approvisionnement> approvisionnement) {
		this.approvisionnement = approvisionnement;
	}


}
