package fr.afcepf.al33.citron.ws.saison.client.dto.debug;

public class ArticleDtoDebug {
	private int					id;
	private String 				nom;
	private int					debutSaison;
	private int					finSaison;
	private CategorieDtoDebug	categorie;
	
	public ArticleDtoDebug(int id, String nom, int debutSaison, int finSaison, CategorieDtoDebug categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.debutSaison = debutSaison;
		this.finSaison = finSaison;
		this.categorie = categorie;
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

	public int getDebutSaison() {
		return debutSaison;
	}

	public void setDebutSaison(int debutSaison) {
		this.debutSaison = debutSaison;
	}

	public int getFinSaison() {
		return finSaison;
	}

	public void setFinSaison(int finSaison) {
		this.finSaison = finSaison;
	}

	public CategorieDtoDebug getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieDtoDebug categorie) {
		this.categorie = categorie;
	}
	
}
