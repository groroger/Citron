
package fr.afcepf.al33.citron.ws.saison.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al33.citron.ws.saison.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListeArticles_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticles");
    private final static QName _ListeArticlesParCategorieResponse_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParCategorieResponse");
    private final static QName _ListeArticlesParNomResponse_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParNomResponse");
    private final static QName _ListeCategories_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeCategories");
    private final static QName _ListeArticlesParMoisResponse_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParMoisResponse");
    private final static QName _ListeArticlesParNom_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParNom");
    private final static QName _ListeArticlesResponse_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesResponse");
    private final static QName _ListeArticlesParCategorie_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParCategorie");
    private final static QName _ListeArticlesParCategorieEtMoisResponse_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParCategorieEtMoisResponse");
    private final static QName _ListeArticlesParMois_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParMois");
    private final static QName _ListeArticlesParCategorieEtMois_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeArticlesParCategorieEtMois");
    private final static QName _ListeCategoriesResponse_QNAME = new QName("http://ws.saison.ws.citron.al33.afcepf.fr/", "listeCategoriesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al33.citron.ws.saison.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListeArticlesResponse }
     * 
     */
    public ListeArticlesResponse createListeArticlesResponse() {
        return new ListeArticlesResponse();
    }

    /**
     * Create an instance of {@link ListeArticlesParNom }
     * 
     */
    public ListeArticlesParNom createListeArticlesParNom() {
        return new ListeArticlesParNom();
    }

    /**
     * Create an instance of {@link ListeArticlesParMoisResponse }
     * 
     */
    public ListeArticlesParMoisResponse createListeArticlesParMoisResponse() {
        return new ListeArticlesParMoisResponse();
    }

    /**
     * Create an instance of {@link ListeArticlesParNomResponse }
     * 
     */
    public ListeArticlesParNomResponse createListeArticlesParNomResponse() {
        return new ListeArticlesParNomResponse();
    }

    /**
     * Create an instance of {@link ListeCategories }
     * 
     */
    public ListeCategories createListeCategories() {
        return new ListeCategories();
    }

    /**
     * Create an instance of {@link ListeArticles }
     * 
     */
    public ListeArticles createListeArticles() {
        return new ListeArticles();
    }

    /**
     * Create an instance of {@link ListeArticlesParCategorieResponse }
     * 
     */
    public ListeArticlesParCategorieResponse createListeArticlesParCategorieResponse() {
        return new ListeArticlesParCategorieResponse();
    }

    /**
     * Create an instance of {@link ListeCategoriesResponse }
     * 
     */
    public ListeCategoriesResponse createListeCategoriesResponse() {
        return new ListeCategoriesResponse();
    }

    /**
     * Create an instance of {@link ListeArticlesParCategorieEtMois }
     * 
     */
    public ListeArticlesParCategorieEtMois createListeArticlesParCategorieEtMois() {
        return new ListeArticlesParCategorieEtMois();
    }

    /**
     * Create an instance of {@link ListeArticlesParCategorieEtMoisResponse }
     * 
     */
    public ListeArticlesParCategorieEtMoisResponse createListeArticlesParCategorieEtMoisResponse() {
        return new ListeArticlesParCategorieEtMoisResponse();
    }

    /**
     * Create an instance of {@link ListeArticlesParMois }
     * 
     */
    public ListeArticlesParMois createListeArticlesParMois() {
        return new ListeArticlesParMois();
    }

    /**
     * Create an instance of {@link ListeArticlesParCategorie }
     * 
     */
    public ListeArticlesParCategorie createListeArticlesParCategorie() {
        return new ListeArticlesParCategorie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticles")
    public JAXBElement<ListeArticles> createListeArticles(ListeArticles value) {
        return new JAXBElement<ListeArticles>(_ListeArticles_QNAME, ListeArticles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParCategorieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParCategorieResponse")
    public JAXBElement<ListeArticlesParCategorieResponse> createListeArticlesParCategorieResponse(ListeArticlesParCategorieResponse value) {
        return new JAXBElement<ListeArticlesParCategorieResponse>(_ListeArticlesParCategorieResponse_QNAME, ListeArticlesParCategorieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParNomResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParNomResponse")
    public JAXBElement<ListeArticlesParNomResponse> createListeArticlesParNomResponse(ListeArticlesParNomResponse value) {
        return new JAXBElement<ListeArticlesParNomResponse>(_ListeArticlesParNomResponse_QNAME, ListeArticlesParNomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeCategories")
    public JAXBElement<ListeCategories> createListeCategories(ListeCategories value) {
        return new JAXBElement<ListeCategories>(_ListeCategories_QNAME, ListeCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParMoisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParMoisResponse")
    public JAXBElement<ListeArticlesParMoisResponse> createListeArticlesParMoisResponse(ListeArticlesParMoisResponse value) {
        return new JAXBElement<ListeArticlesParMoisResponse>(_ListeArticlesParMoisResponse_QNAME, ListeArticlesParMoisResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParNom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParNom")
    public JAXBElement<ListeArticlesParNom> createListeArticlesParNom(ListeArticlesParNom value) {
        return new JAXBElement<ListeArticlesParNom>(_ListeArticlesParNom_QNAME, ListeArticlesParNom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesResponse")
    public JAXBElement<ListeArticlesResponse> createListeArticlesResponse(ListeArticlesResponse value) {
        return new JAXBElement<ListeArticlesResponse>(_ListeArticlesResponse_QNAME, ListeArticlesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParCategorie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParCategorie")
    public JAXBElement<ListeArticlesParCategorie> createListeArticlesParCategorie(ListeArticlesParCategorie value) {
        return new JAXBElement<ListeArticlesParCategorie>(_ListeArticlesParCategorie_QNAME, ListeArticlesParCategorie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParCategorieEtMoisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParCategorieEtMoisResponse")
    public JAXBElement<ListeArticlesParCategorieEtMoisResponse> createListeArticlesParCategorieEtMoisResponse(ListeArticlesParCategorieEtMoisResponse value) {
        return new JAXBElement<ListeArticlesParCategorieEtMoisResponse>(_ListeArticlesParCategorieEtMoisResponse_QNAME, ListeArticlesParCategorieEtMoisResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParMois }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParMois")
    public JAXBElement<ListeArticlesParMois> createListeArticlesParMois(ListeArticlesParMois value) {
        return new JAXBElement<ListeArticlesParMois>(_ListeArticlesParMois_QNAME, ListeArticlesParMois.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeArticlesParCategorieEtMois }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeArticlesParCategorieEtMois")
    public JAXBElement<ListeArticlesParCategorieEtMois> createListeArticlesParCategorieEtMois(ListeArticlesParCategorieEtMois value) {
        return new JAXBElement<ListeArticlesParCategorieEtMois>(_ListeArticlesParCategorieEtMois_QNAME, ListeArticlesParCategorieEtMois.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.saison.ws.citron.al33.afcepf.fr/", name = "listeCategoriesResponse")
    public JAXBElement<ListeCategoriesResponse> createListeCategoriesResponse(ListeCategoriesResponse value) {
        return new JAXBElement<ListeCategoriesResponse>(_ListeCategoriesResponse_QNAME, ListeCategoriesResponse.class, null, value);
    }

}
