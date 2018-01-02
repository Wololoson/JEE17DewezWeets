package be.gestionhopital.Models;

public class Salle {
	//Variables d'instance
	private int idSalle;
	private String numSalle;
	private char bloc;
	
	//Constructeurs
	public Salle() {
		
	}
	
	public Salle(int idSalle,String numSalle,char bloc) {
		this.idSalle = idSalle;
		this.numSalle = numSalle;
		this.bloc = bloc;
	}

	//Propriétés
	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}

	public char getBloc() {
		return bloc;
	}

	public void setBloc(char bloc) {
		this.bloc = bloc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bloc;
		result = prime * result + idSalle;
		result = prime * result + ((numSalle == null) ? 0 : numSalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Salle other = (Salle) obj;
		if (bloc != other.bloc)
			return false;
		if (idSalle != other.idSalle)
			return false;
		if (numSalle == null) {
			if (other.numSalle != null)
				return false;
		} else if (!numSalle.equals(other.numSalle))
			return false;
		return true;
	}
	
	
}
