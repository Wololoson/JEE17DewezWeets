package be.gestionhopital.Models;

import java.sql.Date;

public class Chirurgien extends Personne{
	//Variable d'instance
	private String specialisation;
	
	//Constructeurs
	public Chirurgien() {
		super();
	}
	
	public Chirurgien(String specialisation,int idPersonne,String nom,String prenom,Date dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.specialisation = specialisation;
	}
	
	//Propri�t�s
	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	
	//M�thodes
	@Override
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.specialisation = ((Chirurgien)p).specialisation;
	};
}
