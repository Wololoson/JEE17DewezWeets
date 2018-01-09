package be.gestionhopital.Models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAONotification;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListNotification implements Serializable {
	private static final long serialVersionUID = -254715069091466589L;
	
	// Variable d'instance
	private static ListNotification instance = null;
	private List<Notification> listNotification = new ArrayList<>();
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAONotification notifDAO = (DAONotification) adf.getNotificationDAO();
	
	// Constructeur
	private ListNotification() {
		try {
			listNotification = notifDAO.findAll();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// M�thodes
	public void ajouterNotification(Notification n) {
		boolean found = false;
		for(Notification no : listNotification) {
			if(n.equals(no)) {
				found = true;
			}
		}
		
		if(!found) {
			listNotification.add(n);
			notifDAO.create(n);
		}
	}
	
	public void supprimerNotification(Notification n) {
		Notification foundNoti = null;
		for(Notification no : listNotification) {
			if(n.equals(no)) {
				foundNoti = no;
			}
		}
		
		notifDAO.delete(foundNoti);
		listNotification.remove(foundNoti);
	}
	
	public void supprimerToutesNotification() {
		notifDAO.deleteAll();
		listNotification.clear();
	}
	
	// Cr�ation ou r�cup�ration de l'instance du singleton
	public static synchronized ListNotification getInstance() {
		if(instance == null)
			instance = new ListNotification();
		
		return instance;
	}

	// Propri�t�s
	public List<Notification> getListNotification() {
		return listNotification;
	}

	public void setListNotification(List<Notification> listNotification) {
		this.listNotification = listNotification;
	}
	
	
}
