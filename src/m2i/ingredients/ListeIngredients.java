package m2i.ingredients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListeIngredients implements Serializable {

	protected List<Ingredient> _liste; // les classes filles peuvent h�riter de cet attribut

	/**
	 * Constructeur
	 */
	public ListeIngredients() {
		super();
		this._liste = new ArrayList<>();
	}

	/**
	 * Ajouter un ingr�dient = 1) v�rifier si l'ingr�dient est d�jà dans la liste ;
	 * 2) ajouter l'�l�ment à la liste.
	 * 
	 * @param i
	 */
	public void ajouter(Ingredient i) {
		if (this._liste.contains(i)) {
			System.out.println("L'ingr�dient est d�jà dans la recette");
		} else {
			this._liste.add(i);
		}
	}

	/**
	 * Modifier un ingr�dient = 1) passer en revue tous les �l�ments de la liste ;
	 * 2) v�rifier si le nom de cet �l�ment est identique au nom de l'ingr�dient
	 * modifi� ; 3) modifier l'ingr�dient ('apports' et 'quantite').
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
	 * Supprimer un ingr�dient = 1) v�rifier que l'ingr�dient est dans la liste ; 2)
	 * supprimer l'�l�ment de la liste.
	 * 
	 * @param i
	 */
	public void supprimer(Ingredient i) {
		if (!this._liste.contains(i)) {
			System.out.println("L'ingr�dient n'est pas dans la recette");
		} else {
			this._liste.remove(i);
		}
	}

	/**
	 * Supprimer un ingr�dient en entrant son nom en param�tre.
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
	 * R�cup�rer un ingr�dient de la liste � partir de son id.
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
