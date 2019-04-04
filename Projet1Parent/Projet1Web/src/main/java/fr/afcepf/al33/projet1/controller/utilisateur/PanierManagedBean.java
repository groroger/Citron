package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import fr.afcepf.al33.projet1.entity.ArticleCommande;




@ManagedBean(name="mbPanier")
@SessionScoped
public class PanierManagedBean implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @ManagedProperty(value="#{mbCatalogueClient.articlesCommandes}")
  private List<ArticleCommande> articlesCommandes ;
  
  @ManagedProperty(value="#{mbCatalogueClient.quantiteSaisie}")
  private int quantiteSaisie;

  public List<ArticleCommande> getArticlesCommandes() {
    return articlesCommandes;
  }



  public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
    this.articlesCommandes = articlesCommandes;
  }



  public int getQuantiteSaisie() {
    return quantiteSaisie;
  }



  public void setQuantiteSaisie(int quantiteSaisie) {
    this.quantiteSaisie = quantiteSaisie;
  }

}