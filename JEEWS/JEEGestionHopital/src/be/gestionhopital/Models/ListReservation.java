package be.gestionhopital.Models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOReservation;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListReservation {
	private static ListReservation instance = null;
	private List<Reservation> listReservation = new ArrayList<>();
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOReservation resDAO = (DAOReservation) adf.getReservationDAO();
	
	private ListReservation() {
		try {
			listReservation = resDAO.findAll();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterPatient(Reservation r) {
		listReservation.add(r);
	}
	
	public void modifierReservation(Reservation before, Reservation after) {
		for(Reservation res : listReservation) {
			if(before.equals(res)) {
				res.modifierReservation(after);
			}
		}
	}
	
	public void supprimerPatient(Reservation r) {
		for(Reservation res : listReservation) {
			if(r.equals(res)) {
				listReservation.remove(res);
			}
		}
	}
	
	public static synchronized ListReservation getInstance() {
		if(instance == null)
			instance = new ListReservation();
		
		return instance;
	}
}
