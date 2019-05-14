package fr.afcepf.al33.citron.bd.panierSaisonWS.data;

public class RefPanier {

	private Integer id;
	
	private Integer quantite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public RefPanier(Integer id, Integer quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}
	
}
