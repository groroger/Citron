package fr.afcepf.al33.citron.ws.saison.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor

public class ArticleDto {
	private int			id;
	private String 		nom;
	private int			debutSaison;
	private int			finSaison;
	private CategorieDto	categorie;
}
