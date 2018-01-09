package be.gestionhopital.Models;

import java.io.IOException;

import org.xml.sax.SAXException;

import be.gestionhopital.Factory.AbstractDAOFactory;

public class Chirurgien extends Personne{
	private static final long serialVersionUID = -6713247746739201921L;
	//Variable d'instance
	private String specialisation;
	
	//Constructeurs
	public Chirurgien() {
		super();
	}
	
	public Chirurgien(String specialisation,int idPersonne,String nom,String prenom,String dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.specialisation = specialisation;
	}
	
	//Propriétés
	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	
	//Méthodes
	@Override
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.specialisation = ((Chirurgien)p).specialisation;
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		try {
			adf.getChirurgienDAO().update((Chirurgien)p);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	
	public void ajouterReservation(Reservation r) {
		ListReservation lr = ListReservation.getInstance();
		lr.ajouterReservation(r, null);
	}
	
	public void modifierReservation(Reservation before, Reservation after) {
		ListReservation lr = ListReservation.getInstance();
		lr.modifierReservation(before, after, null);
	}
	
	public void supprimerReservation(Reservation r) {
		ListReservation lr = ListReservation.getInstance();
		lr.supprimerReservation(r, null);
	}
	
	public void supprimerNotification(Notification n) {
		ListNotification ln = ListNotification.getInstance();
		ln.supprimerNotification(n);
	}
	
	public void supprimerToutesNotification() {
		ListNotification ln = ListNotification.getInstance();
		ln.supprimerToutesNotification();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((specialisation == null) ? 0 : specialisation.hashCode());
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
		Chirurgien other = (Chirurgien) obj;
		super.equals(obj);
		if (specialisation == null) {
			if (other.specialisation != null)
				return false;
		} else if (!specialisation.equals(other.specialisation))
			return false;
		return true;
	}
	
}
