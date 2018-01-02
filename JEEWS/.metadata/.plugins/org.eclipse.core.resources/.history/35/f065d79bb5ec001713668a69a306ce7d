package be.gestionhopital.Models;

import java.sql.Date;

public class Secretaire extends Personne {
	// Variable d'instance
	private String service;

	// Constructeurs
	public Secretaire() {
		super();
	}
	
	public Secretaire(String service,int idPersonne,String nom,String prenom,Date dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.service = service;
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
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.service = ((Secretaire)p).service;
	};
}
