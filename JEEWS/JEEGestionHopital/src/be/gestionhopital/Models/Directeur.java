package be.gestionhopital.Models;

import java.sql.Date;

public class Directeur extends Personne {
	private static final long serialVersionUID = 1457950990267848045L;
	// Variable d'instance
	private String code;

	// Constructeurs
	public Directeur() {
		super();
	}
	
	public Directeur(String code,int idPersonne,String nom,String prenom,Date dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.code = code;
	}

	// Propriétés
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// Méthodes
	@Override
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.code = ((Directeur)p).code;
	};
}
