package fr.afcepf.al33.citron.entity;

import java.util.Date;

public class CallWsLivraison {

	private Integer call_id;
	private String id_facture;
	private String address_a;
	private String address_b;
	private Double distance_a_b;
	private Double delivery_price;
	private Double co2_footprint;
	private Date date_commande;
	private String company;

	public Integer getCall_id() {
		return call_id;
	}

	public void setCall_id(Integer call_id) {
		this.call_id = call_id;
	}

	public String getId_facture() {
		return id_facture;
	}

	public void setId_facture(String id_facture) {
		this.id_facture = id_facture;
	}

	public String getAddress_a() {
		return address_a;
	}

	public void setAddress_a(String address_a) {
		this.address_a = address_a;
	}

	public String getAddress_b() {
		return address_b;
	}

	public void setAddress_b(String address_b) {
		this.address_b = address_b;
	}

	public Double getDistance_a_b() {
		return distance_a_b;
	}

	public void setDistance_a_b(Double distance_a_b) {
		this.distance_a_b = distance_a_b;
	}

	public Double getDelivery_price() {
		return delivery_price;
	}

	public void setDelivery_price(Double delivery_price) {
		this.delivery_price = delivery_price;
	}

	public Double getCo2_footprint() {
		return co2_footprint;
	}

	public void setCo2_footprint(Double co2_footprint) {
		this.co2_footprint = co2_footprint;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
