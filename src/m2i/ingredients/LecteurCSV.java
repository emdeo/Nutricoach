package m2i.ingredients;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecteurCSV {

	// Adresse du CSV (mettre à jour selon l'ordinateur utilisé)
	private String _fichier;

	// Séparateur utilisé dans le CSV (';' ou ','...)
	private String _separateur;

	// Objet lisant le contenu du CSV
	private BufferedReader _br = null;

	// Contenu de chaque _ligne du CSV
	private String _ligne = "";

	// Contenu global du CSV sous forme de liste de tableaux (List<String[]>)
	private List<String[]> _lstLignes;

	/**
	 * Constructeur
	 * 
	 * @param _fichier
	 * @param _separateur
	 */
	public LecteurCSV(String _fichier, String _separateur) {
		super();
		this._fichier = _fichier;
		this._separateur = _separateur;
		this._lstLignes = new ArrayList<>();
	}

	/**
	 * Lit et renvoie les lignes d'un fichier CSV sous forme de liste.
	 * 
	 * @return
	 */
	public List<String[]> lireContenu() {
		try {

			// Lecture du _fichier
			_br = new BufferedReader(new FileReader(_fichier));

			// Pour chaque nouvelle _ligne...
			while ((_ligne = _br.readLine()) != null) {

				// Séparer et lire les éléments
				String[] ingredient = _ligne.split(_separateur);
//				System.out.println(ingredient[0] + "\t" + ingredient[1] + "\t" + ingredient[2] + "\t" + ingredient[3]);
				_lstLignes.add(ingredient);
			}

		}

		// Messages d'erreur
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (_br != null) {
				try {
					_br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// Renvoyer le résultat final
		return _lstLignes;

	}

	// Getters & setters

	public String get_fichier() {
		return _fichier;
	}

	public void set_fichier(String _fichier) {
		this._fichier = _fichier;
	}

	public BufferedReader get_br() {
		return _br;
	}

	public void set_br(BufferedReader _br) {
		this._br = _br;
	}

	public String get_ligne() {
		return _ligne;
	}

	public void set_ligne(String _ligne) {
		this._ligne = _ligne;
	}

	public String get_separateur() {
		return _separateur;
	}

	public void set_separateur(String _separateur) {
		this._separateur = _separateur;
	}

	/**
	 * Renvoie le contenu du fichier sans tenir compte de la 1ere ligne (noms de
	 * colonnes). Renvoie null si la méthode lireContenu() n'a pas été exécutée.
	 * 
	 * @return
	 */
	public List<String[]> get_contenu() {
		if (_lstLignes == null) {
			System.out.println("Le contenu du fichier n'a pas été traité");
			return null;
		}
		return _lstLignes.subList(1, _lstLignes.size());
	}

}
