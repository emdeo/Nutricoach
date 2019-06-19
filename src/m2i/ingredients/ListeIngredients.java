package m2i.ingredients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListeIngredients implements Serializable {

	protected List<Ingredient> _liste; // les classes filles peuvent hériter de cet attribut

	/**
	 * Constructeur
	 */
	public ListeIngredients() {
		super();
		this._liste = new ArrayList<>();
	}

	/**
	 * Ajouter un ingrédient = 1) vérifier si l'ingrédient est déjÃ  dans la liste ;
	 * 2) ajouter l'élément Ã  la liste.
	 * 
	 * @param i
	 */
	public void ajouter(Ingredient i) {
		if (this._liste.contains(i)) {
			System.out.println("L'ingrédient est déjÃ  dans la recette");
		} else {
			this._liste.add(i);
		}
	}

	/**
	 * Modifier un ingrédient = 1) passer en revue tous les éléments de la liste ;
	 * 2) vérifier si le nom de cet élément est identique au nom de l'ingrédient
	 * modifié ; 3) modifier l'ingrédient ('apports' et 'quantite').
	 * 
	 * @param i
	 */
	public void modifier(Ingredient i) {
		for (Ingredient ingr : this._liste) {
			if (ingr.get_nom().contentEquals(i.get_nom())) {
				ingr.modifier(i);
			}
		}
	}

	/**
	 * Supprimer un ingrédient = 1) vérifier que l'ingrédient est dans la liste ; 2)
	 * supprimer l'élément de la liste.
	 * 
	 * @param i
	 */
	public void supprimer(Ingredient i) {
		if (!this._liste.contains(i)) {
			System.out.println("L'ingrédient n'est pas dans la recette");
		} else {
			this._liste.remove(i);
		}
	}

	/**
	 * Supprimer un ingrédient en entrant son nom en paramètre.
	 * 
	 * @param nom
	 */
	public void supprimer(String nom) {
		for (Ingredient i : _liste) {
			if (i.get_nom().contentEquals(nom))
				_liste.remove(i);
		}
	}

	// Getters & setters

	public List<Ingredient> get_liste() {
		return _liste;
	}

	public void set_liste(List<Ingredient> _liste) {
		this._liste = _liste;
	}
	
	/**
	 * Récupérer un ingrédient de la liste à partir de son id.
	 * 
	 * @param id
	 * @return
	 */
	public Ingredient get_ingredient(int id) {
		for(Ingredient i : this._liste) {
			if(i.get_id() == id)
				return i;
		}
		System.out.println("ID introuvable");
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for(Ingredient i : _liste) {
			output += i + "\n";
		}
		return output;
	}

}
