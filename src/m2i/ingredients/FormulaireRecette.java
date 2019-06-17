package m2i.ingredients;

/*
 *  Interface utilisateur permettant de créer/modifier des recettes
 */
public class FormulaireRecette {
	
	private Recette recette;
	private ListeRecettes lstRecettes;
	
	public FormulaireRecette() {
		
	}
	
	public void ajouter() {
		
	}
	
	public void annuler() {
		
	}

	public void supprimer() {
	
	}

	public void enregistrer() {
	
	}
	
	public void selectionner(int id) {
		
	}
	
	public void showError(String err) {
		
	}
	
	public void toggleEnabled() {
		
	}
	
	// Getters & setters

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public ListeRecettes getLstRecettes() {
		return lstRecettes;
	}

	public void setLstRecettes(ListeRecettes lstRecettes) {
		this.lstRecettes = lstRecettes;
	}
	
}
