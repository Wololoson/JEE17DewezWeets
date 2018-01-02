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
	private static ListNotification instance = null;
	private List<Notification> listNotification = new ArrayList<>();
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAONotification notifDAO = (DAONotification) adf.getNotificationDAO();
	
	private ListNotification() {
		try {
			listNotification = notifDAO.findAll();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterNotification(Notification n) {
		listNotification.add(n);
		notifDAO.create(n);
	}
	
	public void supprimerNotification(Notification n) {
		for(Notification no : listNotification) {
			if(n.equals(no)) {
				notifDAO.delete(no);
				listNotification.remove(no);
			}
		}
	}
	
	public static synchronized ListNotification getInstance() {
		if(instance == null)
			instance = new ListNotification();
		
		return instance;
	}

	public List<Notification> getListNotification() {
		return listNotification;
	}

	public void setListNotification(List<Notification> listNotification) {
		this.listNotification = listNotification;
	}
	
	
}
