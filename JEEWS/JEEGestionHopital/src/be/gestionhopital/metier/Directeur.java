package be.gestionhopital.metier;

public class Directeur extends Personne {
	// Variable d'instance
	private int code;

	// Constructeur
	public Directeur() {
		super();
	}

	// Propri�t�s
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	// M�thodes
	@Override
	public void modifierInfos() {

	};
}