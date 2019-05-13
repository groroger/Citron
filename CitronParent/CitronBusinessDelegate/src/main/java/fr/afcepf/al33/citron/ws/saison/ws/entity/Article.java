
package fr.afcepf.al33.citron.ws.saison.ws.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour article complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categorie" type="{http://entity.ws.saison.ws.citron.al33.afcepf.fr/}categorie" minOccurs="0"/>
 *         &lt;element name="debutSaison" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="finSaison" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "article", propOrder = {
    "categorie",
    "debutSaison",
    "finSaison",
    "id",
    "nom"
})
public class Article {

    protected Categorie categorie;
    protected int debutSaison;
    protected int finSaison;
    protected int id;
    protected String nom;

    /**
     * Obtient la valeur de la propriété categorie.
     * 
     * @return
     *     possible object is
     *     {@link Categorie }
     *     
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Définit la valeur de la propriété categorie.
     * 
     * @param value
     *     allowed object is
     *     {@link Categorie }
     *     
     */
    public void setCategorie(Categorie value) {
        this.categorie = value;
    }

    /**
     * Obtient la valeur de la propriété debutSaison.
     * 
     */
    public int getDebutSaison() {
        return debutSaison;
    }

    /**
     * Définit la valeur de la propriété debutSaison.
     * 
     */
    public void setDebutSaison(int value) {
        this.debutSaison = value;
    }

    /**
     * Obtient la valeur de la propriété finSaison.
     * 
     */
    public int getFinSaison() {
        return finSaison;
    }

    /**
     * Définit la valeur de la propriété finSaison.
     * 
     */
    public void setFinSaison(int value) {
        this.finSaison = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

}
