package fr.afcepf.al33.projet1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="articleCommande")
public class ArticleCommande implements Serializable{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id", nullable=false)
		private Integer id;
		
		@Column(name="quantite")
		private int quantite;
		
		@ManyToOne
		@JoinColumn(referencedColumnName="id")
		private Article article;
		
		@ManyToOne
		@JoinColumn(referencedColumnName="id")
		private Commande commande;

		public ArticleCommande() {
			super();
			
		}

		public ArticleCommande(Integer id, int quantite, Article article, Commande commande) {
			super();
			this.id = id;
			this.quantite = quantite;
			this.article = article;
			this.commande = commande;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}

		public Article getArticle() {
			return article;
		}

		public void setArticle(Article article) {
			this.article = article;
		}

		public Commande getCommande() {
			return commande;
		}

		public void setCommande(Commande commande) {
			this.commande = commande;
		}
		
		
	

}
