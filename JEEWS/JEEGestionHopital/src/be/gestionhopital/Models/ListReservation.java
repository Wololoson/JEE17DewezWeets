package be.gestionhopital.Models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOReservation;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListReservation implements Serializable {
	private static final long serialVersionUID = 6264935516442700531L;
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
	
	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public void ajouterReservation(Reservation r) {
		listReservation.add(r);
		resDAO.create(r);
	}
	
	public void modifierReservation(Reservation before, Reservation after) {
		for(Reservation res : listReservation) {
			if(before.equals(res)) {
				res.modifierReservation(after);
				resDAO.update(res);
			}
		}
	}
	
	public void supprimerReservation(Reservation r) {
		for(Reservation res : listReservation) {
			if(r.equals(res)) {
				resDAO.delete(res);
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
