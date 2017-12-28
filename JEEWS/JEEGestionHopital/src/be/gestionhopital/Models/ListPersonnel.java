package be.gestionhopital.Models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOChirurgien;
import be.gestionhopital.DAO.DAOSecretaire;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListPersonnel {
	private static ListPersonnel instance = null;
	private List<Secretaire> listSecretaire = new ArrayList<>();
	private List<Chirurgien> listChirurgien = new ArrayList<>();
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOSecretaire secrDAO = (DAOSecretaire) adf.getSecretaireDAO();
	private DAOChirurgien chirDAO = (DAOChirurgien) adf.getChirurgienDAO();
	
	private ListPersonnel() {
		try {
			listSecretaire = secrDAO.findAll();
			listChirurgien = chirDAO.findAll();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterPersonnel(Personne p) {
		if(p instanceof Secretaire) {
			listSecretaire.add((Secretaire)p);
		}
		else {
			listChirurgien.add((Chirurgien)p);
		}
	}
	
	public void supprimerPersonnel(Personne p) {
		if(p instanceof Secretaire) {
			for(Secretaire s : listSecretaire) {
				if(p.equals(s)) {
					listSecretaire.remove(s);
				}
			}
		}
		else {
			for(Chirurgien c : listChirurgien) {
				if(p.equals(c)) {
					listChirurgien.remove(c);
				}
			}
		}
	}
	
	public static synchronized ListPersonnel getInstance() {
		if(instance == null)
			instance = new ListPersonnel();
		
		return instance;
	}
}