
package fr.afcepf.al33.citron.ws.saison.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour listeArticlesParMois complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="listeArticlesParMois">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mois" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listeArticlesParMois", propOrder = {
    "mois"
})
public class ListeArticlesParMois {

    protected int mois;

    /**
     * Obtient la valeur de la propriété mois.
     * 
     */
    public int getMois() {
        return mois;
    }

    /**
     * Définit la valeur de la propriété mois.
     * 
     */
    public void setMois(int value) {
        this.mois = value;
    }

}
