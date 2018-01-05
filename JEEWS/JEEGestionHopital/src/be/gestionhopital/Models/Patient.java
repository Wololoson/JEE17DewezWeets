package be.gestionhopital.Models;

public class Patient extends Personne {
	private static final long serialVersionUID = -6666981989406454568L;
	// Variables d'instance
	private String numChambre;
	private String numPatient;

	// Constructeurs
	public Patient() {
		super();
	}
	
	public Patient(String numChambre,String numPatient,int idPersonne,String nom,String prenom,String dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.numChambre = numChambre;
		this.numPatient = numPatient;
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
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.numChambre = ((Patient)p).numChambre;
		this.numPatient = ((Patient)p).numPatient;
	};
}
