package fr.afcepf.al33.citron.bd.panierSaisonWS.data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace="data.panierSaisonWS.bd.citron.al33.afcepf.fr")
@XmlRootElement(name="article")
public class Article {
    private String categorie;

    private Integer debutSaison;

    private Integer finSaison;

    private Integer id;

    private String nom;

    private Double prix;

    private Double prixKilo;

    private Double quantiteVendue;

    public Article() {
    }

    public Article(
           String categorie,
           Integer debutSaison,
           Integer finSaison,
           Integer id,
           String nom,
           Double prix,
           Double prixKilo,
           Double quantiteVendue) {
           this.categorie = categorie;
           this.debutSaison = debutSaison;
           this.finSaison = finSaison;
           this.id = id;
           this.nom = nom;
           this.prix = prix;
           this.prixKilo = prixKilo;
           this.quantiteVendue = quantiteVendue;
    }


    /**
     * Gets the categorie value for this Article.
     * 
     * @return categorie
     */
    public String getCategorie() {
        return categorie;
    }


    /**
     * Sets the categorie value for this Article.
     * 
     * @param categorie
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    /**
     * Gets the debutSaison value for this Article.
     * 
     * @return debutSaison
     */
    public Integer getDebutSaison() {
        return debutSaison;
    }


    /**
     * Sets the debutSaison value for this Article.
     * 
     * @param debutSaison
     */
    public void setDebutSaison(Integer debutSaison) {
        this.debutSaison = debutSaison;
    }


    /**
     * Gets the finSaison value for this Article.
     * 
     * @return finSaison
     */
    public Integer getFinSaison() {
        return finSaison;
    }


    /**
     * Sets the finSaison value for this Article.
     * 
     * @param finSaison
     */
    public void setFinSaison(Integer finSaison) {
        this.finSaison = finSaison;
    }


    /**
     * Gets the id value for this Article.
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Article.
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Gets the nom value for this Article.
     * 
     * @return nom
     */
    public String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this Article.
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Gets the prix value for this Article.
     * 
     * @return prix
     */
    public Double getPrix() {
        return prix;
    }


    /**
     * Sets the prix value for this Article.
     * 
     * @param prix
     */
    public void setPrix(Double prix) {
        this.prix = prix;
    }


    /**
     * Gets the prixKilo value for this Article.
     * 
     * @return prixKilo
     */
    public Double getPrixKilo() {
        return prixKilo;
    }


    /**
     * Sets the prixKilo value for this Article.
     * 
     * @param prixKilo
     */
    public void setPrixKilo(Double prixKilo) {
        this.prixKilo = prixKilo;
    }


    /**
     * Gets the quantiteVendue value for this Article.
     * 
     * @return quantiteVendue
     */
    public Double getQuantiteVendue() {
        return quantiteVendue;
    }
}

