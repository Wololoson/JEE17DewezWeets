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

	// Propriétés
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

	// Méthodes
	@Override
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.numChambre = ((Patient)p).numChambre;
		this.numPatient = ((Patient)p).numPatient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numChambre == null) ? 0 : numChambre.hashCode());
		result = prime * result + ((numPatient == null) ? 0 : numPatient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (numChambre == null) {
			if (other.numChambre != null)
				return false;
		} else if (!numChambre.equals(other.numChambre))
			return false;
		if (numPatient == null) {
			if (other.numPatient != null)
				return false;
		} else if (!numPatient.equals(other.numPatient))
			return false;
		return true;
	};
	
}
