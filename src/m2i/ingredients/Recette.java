package m2i.ingredients;

import java.util.List;

public class Recette extends ListeIngredients {

	private int _id;
	private String _nom;
	private float _apports; // total d'apports énergétiques (kCals)

	public Recette(int _id, String _nom, float _apports, List<Ingredient> liste) {
		super();
		this._id = _id;
		this._nom = _nom;
		this._apports = _apports;
		super._liste = liste; // hérité de la classe ListeIngredients
	}

	/**
	 * Ajouter un ingrédient =
	 * 3) mettre à jour l'apport énergétique
	 * total.
	 * 
	 * @param i
	 */
	public void ajouter(Ingredient i) {
		if (super._liste.contains(i)) {
			System.out.println("L'ingrédient est déjà dans la recette");
		} else {
			super._liste.add(i);
			this._apports = calculApports();
		}
	}

	/**
	 * Modifier un ingrédient =
	 * 1) passer en revue tous les éléments de la liste ;
	 * 2) vérifier si le nom de cet élément est identique au nom de l'ingrédient
	 * modifié ;
	 * 3) modifier l'ingrédient ('apports' et 'quantite').
	 * 
	 * @param i
	 */
	public void modifier(Ingredient i) {
		for (Ingredient ingr : super._liste) {
			if (ingr.get_nom().contentEquals(i.get_nom())) {
				ingr.modifier(i);
				this._apports = calculApports();
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
			super._liste.remove(i);
			this._apports = calculApports();
		}
	}

	/**
	 * Calcule l'apport énergétique total de la recette en multipliant la quantité
	 * de chaque ingrédient par son apport.
	 * 
	 * @return
	 */
	public float calculApports() {
		float total = 0;
		for (Ingredient i : super._liste)
			total += i.get_apports() * i.get_quantite();
		return total;
	}

	// Getters & setters

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public float get_apports() {
		return _apports;
	}

	public void set_apports(float _apports) {
		this._apports = _apports;
	}

	public List<Ingredient> get_liste() {
		return super._liste;
	}

	public void set_liste(List<Ingredient> _liste) {
		super._liste = _liste;
	}

}
