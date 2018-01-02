package be.gestionhopital.Models;

import java.io.IOException;
import java.io.Serializable;

import org.xml.sax.SAXException;

import be.gestionhopital.Factory.AbstractDAOFactory;

public class Salle implements Serializable {
	private static final long serialVersionUID = 2269384722883408644L;
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
	
	public void ajouterSalle() {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		try {
			adf.getSalleDAO().create(this);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
