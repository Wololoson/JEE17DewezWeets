package be.gestionhopital.Models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOReservation;
import be.gestionhopital.DAO.DAOSalle;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListReservation implements Serializable {
	private static final long serialVersionUID = 6264935516442700531L;
	
	// Variable d'instance
	private static ListReservation instance = null;
	private List<Reservation> listReservation = new ArrayList<>();
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOReservation resDAO = (DAOReservation) adf.getReservationDAO();
	private DAOSalle salleDAO = (DAOSalle)adf.getSalleDAO();

	// Constructeur
	private ListReservation() {
		try {
			listReservation = resDAO.findAll();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	// Propri�t�s
	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	// M�thodes
	public void ajouterReservation(Reservation r, Notification n) {
		boolean found = false;
		ListPatient lp = ListPatient.getInstance();
		lp.ajouterPatient(r.getPatient());
		salleDAO.create(r.getSalle());
		
		for(Reservation re : listReservation) {
			if(r.equals(re)) {
				found = true;
			}
		}
		
		if(!found) {
			listReservation.add(r);
			resDAO.create(r);
			if(n != null) {
				ListNotification ln = ListNotification.getInstance();
				ln.ajouterNotification(n);
			}
		}
	}
	
	public void modifierReservation(Reservation before, Reservation after, Notification n) {
		for(Reservation res : listReservation) {
			if(before.equals(res)) {
				res.modifierReservation(after);
				resDAO.update(after);
				if(n != null) {
					ListNotification ln = ListNotification.getInstance();
					ln.ajouterNotification(n);
				}
			}
		}
	}
	
	public void supprimerReservation(Reservation r, Notification n) {
		Reservation foundRes = null;
		for(Reservation res : listReservation) {
			if(r.equals(res)) {
				foundRes = res;
			}
		}
		
		resDAO.delete(foundRes);
		listReservation.remove(foundRes);
		if(n != null) {
			ListNotification ln = ListNotification.getInstance();
			ln.ajouterNotification(n);
		}
	}

	// Cr�ation ou r�cup�ration de l'instance du singleton
	public static synchronized ListReservation getInstance() {
		if(instance == null)
			instance = new ListReservation();
		
		return instance;
	}
}
