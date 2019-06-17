package m2i.tests;

import java.util.ArrayList;
import java.util.List;

import m2i.ingredients.Categorie;
import m2i.ingredients.Ingredient;
import m2i.ingredients.LecteurCSV;
import m2i.ingredients.ListeIngredients;

public class Main {

	public static void main(String[] args) {

		// Chemin du fichier CSV (ingredients)
		String fichier = "C:\\Users\\Administrateur\\Desktop\\eclipse-workspace\\Nutricoach_Metier\\Aliments_Apports caloriques.csv";
		
		// Séparateur du fichier CSV
		String sep = ";";

		// Enregistrer le contenu du fichier CSV
		LecteurCSV csv = new LecteurCSV(fichier, sep);
		csv.lireContenu();
		List<String[]> contenuCSV = csv.get_contenu();
		
		// Instancier la liste d'ingrédients à partir du contenu du CSV
		ListeIngredients ingredients = new ListeIngredients();
		int ingr_id = 1;
		
		for (String[] i : contenuCSV) {
			
			String nom = i[0];
			float apports = Float.parseFloat(i[1]); // à convertir en float
			Categorie categorie = Categorie.valueOf(i[2]);
			String[] repas = i[3].split((String) ", ");
			
			ingredients.ajouter(new Ingredient(ingr_id, nom, apports, categorie, repas));
			
			ingr_id++;
		}
		
		System.out.println(ingredients);

	}
}
