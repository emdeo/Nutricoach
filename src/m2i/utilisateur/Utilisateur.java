package m2i.utilisateur;

import java.time.LocalDate;
import java.time.Period;

public class Utilisateur {

	private LocalDate _DateNaissance;
	private float _Taille;
	private float _Poids;
	private Sexe _Sexe;
	private Activite _Activite;
	
	private float _IMC;
	private String _Diagnostic;
	private float _MB;

	private Regime _Regime;
	private Objectif _Objectif;

	/**
	 * Constructeur.
	 * 
	 * @param _DateNaissance
	 * @param _Taille
	 * @param _Poids
	 * @param _Sexe
	 * @param _Activite
	 */
	public Utilisateur(LocalDate _DateNaissance, float _Taille, float _Poids, Sexe _Sexe, Activite _Activite) {
		super();
		this._DateNaissance = _DateNaissance;
		this._Taille = _Taille;
		this._Poids = _Poids;
		this._Sexe = _Sexe;
		this._Activite = _Activite;
	}

	/**
	 * Calculer un âge (en années) à partir de la différence entre 2 LocalDates.
	 * 
	 * @param naissance
	 * @param aujd
	 * @return
	 */
	public int calculAge(LocalDate naissance, LocalDate aujd) {
		if ((naissance != null) && (aujd != null)) {
			return Period.between(naissance, aujd).getYears();
		} else {
			return 0;
		}
	}

	/**
	 * Calculer l'indice de masse corporelle.
	 * 
	 * @param taille
	 * @param poids
	 * @return
	 */
	public float calculIMC(float taille, float poids) {
		return poids / taille * taille;
	}

	/**
	 * Diagnostic de l'utilisateur en fonction de son imc.
	 * 
	 * @param imc
	 * @return
	 */
	public String calculDiagnostic(float imc) {
		if (imc < 16)
			return ("Anorexique");
		else if (imc < 18.5)
			return ("Maigre");
		else if (imc < 25)
			return ("Normal");
		else if (imc < 30)
			return ("Surpoids");
		else if (imc < 35)
			return ("Obésité modérée (classe 1)");
		else if (imc < 40)
			return ("Obésité élevée (Classe 2)");
		else
			return ("Obésité morbide");
	}

	/**
	 * Calculer le métabolisme de base.
	 * 
	 * @param sexe
	 * @param poids
	 * @param taille
	 * @param age
	 * @param activite
	 * @return
	 */
	public float calculMB(Sexe sexe, float poids, float taille, int age, Activite activite) {

		float mb;

		if (sexe == Sexe.femme) {
			mb = (9.56f * poids) + (184.96f * taille) - (4.68f * age) + 655.1f;
		} else {
			mb = (13.75f * poids) + (500.33f * taille) - (6.76f * age) + 66.47f;
		}

		switch (activite) {
		case sedentaire:
			return mb * 1.4f;
		case legere:
			return mb * 1.5f;
		case moderee:
			return mb * 1.6f;
		case intense:
			return mb * 1.8f;
		default:
			return mb * 1.2f;
		}
	}

	// Getters & setters

	public LocalDate get_DateNaissance() {
		return _DateNaissance;
	}

	public void set_DateNaissance(LocalDate _DateNaissance) {
		this._DateNaissance = _DateNaissance;
	}

	public int get_Age() {
		return calculAge(_DateNaissance, LocalDate.now());
	}

	public float get_Taille() {
		return _Taille;
	}

	public void set_Taille(float _Taille) {
		this._Taille = _Taille;
	}

	public float get_Poids() {
		return _Poids;
	}

	public void set_Poids(float _Poids) {
		this._Poids = _Poids;
	}

	public Sexe get_Sexe() {
		return _Sexe;
	}

	public void set_Sexe(Sexe _Sexe) {
		this._Sexe = _Sexe;
	}

	public Activite get_Activite() {
		return _Activite;
	}

	public void set_Activite(Activite _Activite) {
		this._Activite = _Activite;
	}

	public float get_IMC() {
//		this._IMC = calculIMC(this._Taille, this._Poids);
		return calculIMC(this._Taille, this._Poids);
	}

	public String get_Diagnostic() {
//		this._Diagnostic = calculDiagnostic(get_IMC());
		return calculDiagnostic(get_IMC());
	}

	public float get_MB() {
//		this._MB = calculMB(this._Sexe, this._Poids, this._Taille, get_Age(), this._Activite);
		return calculMB(this._Sexe, this._Poids, this._Taille, get_Age(), this._Activite);
	}

	public Regime get_Regime() {
		return _Regime;
	}

	public void set_Regime(Regime _Regime) {
		this._Regime = _Regime;
	}

	public Objectif get_Objectif() {
		return _Objectif;
	}

	public void set_Objectif(Objectif _Objectif) {
		this._Objectif = _Objectif;
	}

}
