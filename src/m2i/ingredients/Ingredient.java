package m2i.ingredients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Suggestion : g�n�rer la liste d'objets Ingredient à partir d'un fichier CSV (ou autre format).
 * 
 * Ce fichier servira à ajouter/modifier des aliments (mais pas à les supprimer : il faut en
 * conserver une trace. L'utilisateur peut choisir ceux qu'il souhaite voir s'afficher à
 * partir de l'interface).
 */
public class Ingredient implements Serializable {

	private int _id;
	private String _nom;
	private float _apports; // kCals / 100g
	private float _quantite; // grammes (la quantit� est fix�e quand on cr�e/consulte une recette, pas
								// quand
								// l'objet est instanci�)

	private Categorie _categorie; // fruit, poisson, laitage...
	private String[] _repas; // liste des repas dans lesquels l'ingr�dient peut être utilis�

	private boolean _estSelect; // ingr�dient valid� ou supprim� par l'utilisateur (si 'false', n'appara�t pas
								// dans les recettes propos�es)

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
	 * Modifier les valeurs des attributs d'un ingr�dient (hormis son id).
	 * 
	 * @param i
	 */
	public void modifier(Ingredient i) {
		/*
		 * L'attribut 'nom' n'est pas modifi� puisqu'on suppose qu'il s'agit du même
		 * ingr�dient
		 */
		this._apports = i.get_apports();
		this._quantite = i.get_quantite();
	}

	/**
	 * V�rifie si deux ingr�dients portent le même nom.
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
		return _id + ") " + _nom + " : " + _categorie + " (" + _apports + " kCals/100" + unite + ") - Selectionn� = "
				+ this._estSelect;
	}
}
