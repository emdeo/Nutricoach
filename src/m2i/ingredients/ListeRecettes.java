package m2i.ingredients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListeRecettes implements Serializable {

	private List<Ingredient> _lstIngredients; // liste de TOUS les ingrédients
	private List<Recette> _lstRecettes; // liste de toutes les recettes

	/**
	 * Constructeur
	 */
	public ListeRecettes() {
		this._lstIngredients = new ArrayList<Ingredient>();
		this._lstRecettes = new ArrayList<Recette>();
	}

	/**
	 * Ajouter une recette
	 * 
	 * @param r
	 */
	public void ajouterRecette(Recette r) {
		if (this._lstRecettes.contains(r))
			System.out.println("La recette est déjà enregistrée");
		else
			this._lstRecettes.add(r);
	}

	/**
	 * Supprimer une recette
	 * 
	 * @param r
	 */
	public void supprimerRecette(Recette r) {
		if (!this._lstRecettes.contains(r))
			System.out.println("La recette n'est pas enregistrée");
		else
			this._lstRecettes.remove(r);
	}

	// Getters & setters

	/**
	 * Récupérer une recette à partir de son index.
	 * 
	 * @param i
	 * @return
	 */
	public Recette get_recette(int i) {
		return this._lstRecettes.get(i);
	}

	/**
	 * Récupérer une recette à partir de son nom =
	 * 1) passer en revue tous les éléments de la liste ;
	 * 2) vérifier si le nom de la recette correspond à celui passé en paramètre ;
	 * 3) renvoyer la recette si trouvé, renvoyer 'null' sinon.
	 * 
	 * @param nom
	 * @return
	 */
	public Recette get_recette(String nom) {
		for (Recette r : this._lstRecettes) {
			if (nom.toLowerCase().equals(r.get_nom().toLowerCase()))
				return r;
		}
		return null;
	}

	public List<Ingredient> get_lstIngredients() {
		return _lstIngredients;
	}

	public List<Recette> get_lstRecettes() {
		return _lstRecettes;
	}

}
