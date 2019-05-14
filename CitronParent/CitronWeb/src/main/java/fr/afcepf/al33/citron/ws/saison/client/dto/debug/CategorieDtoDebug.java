package fr.afcepf.al33.citron.ws.saison.client.dto.debug;

public class CategorieDtoDebug {
	private int			id;
	private String 		nom;
	public CategorieDtoDebug(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
