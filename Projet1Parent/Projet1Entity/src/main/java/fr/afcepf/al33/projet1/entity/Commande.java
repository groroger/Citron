package fr.afcepf.al33.projet1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande implements Serializable {

	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id", nullable=false)
		private Integer id;
		
		@Column(name="dateCreation")
		private Date dateCreation;
		
		@Column(name="dateAnnulation")
		private Date dateAnnulation;
			
		@Column(name="dateRemboursement")
		private Date dateRemboursement;
		
		@Column(name="dateExpedition")
		private Date dateExpedition;

		@Column(name="dateLivraison")
		private Date dateLivraison;
		
		@ManyToOne
		@JoinColumn(referencedColumnName="id")
		private Client client;
	
		@OneToMany(fetch=FetchType.EAGER, mappedBy="commande", cascade=CascadeType.ALL)
		private List<ArticleCommande> articlesCommandes;

		public Commande() {
			super();
			
		}

		public Commande(Integer id, Date dateCreation, Date dateAnnulation, Date dateRemboursement, Date dateExpedition,
				Date dateLivraison, Client client, List<ArticleCommande> articlesCommandes) {
			super();
			this.id = id;
			this.dateCreation = dateCreation;
			this.dateAnnulation = dateAnnulation;
			this.dateRemboursement = dateRemboursement;
			this.dateExpedition = dateExpedition;
			this.dateLivraison = dateLivraison;
			this.client = client;
			this.articlesCommandes = articlesCommandes;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public Date getDateAnnulation() {
			return dateAnnulation;
		}

		public void setDateAnnulation(Date dateAnnulation) {
			this.dateAnnulation = dateAnnulation;
		}

		public Date getDateRemboursement() {
			return dateRemboursement;
		}

		public void setDateRemboursement(Date dateRemboursement) {
			this.dateRemboursement = dateRemboursement;
		}

		public Date getDateExpedition() {
			return dateExpedition;
		}

		public void setDateExpedition(Date dateExpedition) {
			this.dateExpedition = dateExpedition;
		}

		public Date getDateLivraison() {
			return dateLivraison;
		}

		public void setDateLivraison(Date dateLivraison) {
			this.dateLivraison = dateLivraison;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public List<ArticleCommande> getArticlesCommandes() {
			return articlesCommandes;
		}

		public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
			this.articlesCommandes = articlesCommandes;
		}
	

}