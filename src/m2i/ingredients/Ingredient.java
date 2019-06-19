package m2i.ingredients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Suggestion : générer la liste d'objets Ingredient Ã  partir d'un fichier CSV (ou autre format).
 * 
 * Ce fichier servira Ã  ajouter/modifier des aliments (mais pas Ã  les supprimer : il faut en
 * conserver une trace. L'utilisateur peut choisir ceux qu'il souhaite voir s'afficher Ã 
 * partir de l'interface).
 */
public class Ingredient implements Serializable {

	private int _id;
	private String _nom;
	private float _apports; // kCals / 100g
	private float _quantite; // grammes (la quantité est fixée quand on crée/consulte une recette, pas
								// quand
								// l'objet est instancié)

	private Categorie _categorie; // fruit, poisson, laitage...
	private String[] _repas; // liste des repas dans lesquels l'ingrédient peut Ãªtre utilisé

	private boolean _estSelect; // ingrédient validé ou supprimé par l'utilisateur (si 'false', n'apparaît pas
								// dans les recettes proposées)

	/**
	 * Constructeur (la 1ere lettre du nom est en capitale)
	 * 
	 * @param _nom
	 * @param _apports
	 * @param _categorie
	 * @param _repas
	 */
	public Ingredient(int id, String nom, float apports, Categorie categorie, String[] repas) {
		super();
		this._id = id;
		this._nom = nom.substring(0, 1).toUpperCase() + nom.substring(1, nom.length()).toLowerCase();
		this._apports = apports;
		this._categorie = categorie;
		this._repas = repas;

		this._estSelect = true;
	}

	/**
	 * Modifier les valeurs des attributs d'un ingrédient (hormis son id).
	 * 
	 * @param i
	 */
	public void modifier(Ingredient i) {
		/*
		 * L'attribut 'nom' n'est pas modifié puisqu'on suppose qu'il s'agit du mÃªme
		 * ingrédient
		 */
		this._apports = i.get_apports();
		this._quantite = i.get_quantite();
	}

	/**
	 * Vérifie si deux ingrédients portent le mÃªme nom.
	 * 
	 * @param o
	 * @return
	 */
	public boolean equals(Object o) {

		Ingredient i = (Ingredient) o;

		if (i.get_nom().toLowerCase().equals(this._nom.toLowerCase()))
			return true;
		return false;

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

	public float get_quantite() {
		return _quantite;
	}

	public void set_quantite(float _quantite) {
		this._quantite = _quantite;
	}

	public Categorie get_categorie() {
		return _categorie;
	}

	public void set_categorie(Categorie _categorie) {
		this._categorie = _categorie;
	}

	public String[] get_repas() {
		return _repas;
	}

	public void set_repas(String[] _repas) {
		this._repas = _repas;
	}

	public boolean is_Select() {
		return _estSelect;
	}

	public void set_Select(boolean _estSelect) {
		this._estSelect = _estSelect;
	}

	/**
	 * Si c'est un lait, une creme ou une boisson, afficher les apports pour 100mL ;
	 * afficher pour 100 grammes sinon
	 */
	@Override
	public String toString() {
		String unite = "g";
		if (_categorie == Categorie.Boisson || _categorie == Categorie.Alcool || _nom.contains("Lait")
				|| _nom.contains("Creme"))
			unite = "mL";
		return _id + ") " + _nom + " : " + _categorie + " (" + _apports + " kCals/100" + unite + ") - Selectionné = "
				+ this._estSelect;
	}
}
