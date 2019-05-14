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

}