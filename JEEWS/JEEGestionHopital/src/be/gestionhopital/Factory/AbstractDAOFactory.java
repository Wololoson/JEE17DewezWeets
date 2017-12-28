package be.gestionhopital.Factory;

import be.gestionhopital.DAO.DAO;
import be.gestionhopital.Models.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Chirurgien> getChirurgienDAO();
	
	public abstract DAO<Directeur> getDirecteurDAO();
		
	public abstract DAO<Notification> getNotificationDAO();
	
	public abstract DAO<Patient> getPatientDAO();
	
	public abstract DAO<Reservation> getReservationDAO();
	
	public abstract DAO<Salle> getSalleDAO();
	
	public abstract DAO<Secretaire> getSecretaireDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}

}
