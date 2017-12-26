package be.gestionhopital.metier;

public class Secretaire extends Personne {
	// Variable d'instance
	private String service;

	// Constructeur
	public Secretaire() {
		super();
	}

	// Propriétés
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	// Méthodes
	@Override
	public void modifierInfos() {

	};
}
