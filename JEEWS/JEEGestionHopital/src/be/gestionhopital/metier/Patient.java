package be.gestionhopital.metier;

public class Patient extends Personne {
	// Variables d'instance
	private String numChambre;
	private String numPatient;

	// Constructeur
	public Patient() {
		super();
	}

	// Propri�t�s
	public String getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(String numChambre) {
		this.numChambre = numChambre;
	}

	public String getNumPatient() {
		return numPatient;
	}

	public void setNumPatient(String numPatient) {
		this.numPatient = numPatient;
	}

	// M�thodes
	@Override
	public void modifierInfos() {

	};
}
