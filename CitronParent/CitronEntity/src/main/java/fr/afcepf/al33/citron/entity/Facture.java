package fr.afcepf.al33.citron.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Add by Amin
 *
 */

@Entity
@Table(name = "facture")
public class Facture implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "id", nullable = false)
		private String id;
	
		@Column(name = "date_creation")
		private Date date_creation;
	
		@Column(name = "co2_footprint")
		private Double co2_footprint;
	
		@Column(name = "delivery_price")
		private Double delivery_price;
	
		@ManyToOne
		@JoinColumn(referencedColumnName = "id")
		private Client client;
	
		@ManyToOne
		@JoinColumn(referencedColumnName = "id")
		private Commande commande;
	
		// Constructeur vide
	
		public Facture() {
			super();
	
		}
		
		//Constructeur chargé

		public Facture(String id, Date date_creation, Double co2_footprint, Double delivery_price, Client client,
				Commande commande) {
			super();
			this.id = id;
			this.date_creation = date_creation;
			this.co2_footprint = co2_footprint;
			this.delivery_price = delivery_price;
			this.client = client;
			this.commande = commande;
		}

		public String getId() {
			return id;
		}
	
		public void setId(String id) {
			this.id = id;
		}
	
		public Date getDate_creation() {
			return date_creation;
		}
	
		public void setDate_creation(Date date_creation) {
			this.date_creation = date_creation;
		}
	
		public Double getCo2_footprint() {
			return co2_footprint;
		}
	
		public void setCo2_footprint(Double co2_footprint) {
			this.co2_footprint = co2_footprint;
		}
	
		public Double getDelivery_price() {
			return delivery_price;
		}
	
		public void setDelivery_price(Double delivery_price) {
			this.delivery_price = delivery_price;
		}
	
		public Client getClient() {
			return client;
		}
	
		public void setClient(Client client) {
			this.client = client;
		}
	
		public Commande getCommande() {
			return commande;
		}
	
		public void setCommande(Commande commande) {
			this.commande = commande;
		}
		
		

}