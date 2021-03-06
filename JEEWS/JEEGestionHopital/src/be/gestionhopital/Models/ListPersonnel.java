package be.gestionhopital.Models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOChirurgien;
import be.gestionhopital.DAO.DAODirecteur;
import be.gestionhopital.DAO.DAOSecretaire;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListPersonnel implements Serializable {
	private static final long serialVersionUID = -6163591791108782171L;
	
	// Variable d'instance
	private static ListPersonnel instance = null;
	private List<Secretaire> listSecretaire = new ArrayList<>();
	private List<Chirurgien> listChirurgien = new ArrayList<>();
	private Directeur directeur;
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOSecretaire secrDAO = (DAOSecretaire) adf.getSecretaireDAO();
	private DAOChirurgien chirDAO = (DAOChirurgien) adf.getChirurgienDAO();
	private DAODirecteur direDAO = (DAODirecteur) adf.getDirecteurDAO();

	// Constructeur
	private ListPersonnel() {
		try {
			listSecretaire = secrDAO.findAll();
			listChirurgien = chirDAO.findAll();
			directeur = direDAO.find(0);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	// Propri�t�s
	public Directeur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	public List<Secretaire> getListSecretaire() {
		return listSecretaire;
	}

	public void setListSecretaire(List<Secretaire> listSecretaire) {
		this.listSecretaire = listSecretaire;
	}

	public List<Chirurgien> getListChirurgien() {
		return listChirurgien;
	}

	public void setListChirurgien(List<Chirurgien> listChirurgien) {
		this.listChirurgien = listChirurgien;
	}

	// M�thodes
	public void ajouterPersonnel(Personne p) {
		boolean found = false;		
		
		if(p instanceof Secretaire) {
			for(Personne pe : listSecretaire) {
				if(p.equals(pe)) {
					found = true;
				}
			}
			
			if(!found) {
				listSecretaire.add((Secretaire)p);
				secrDAO.create((Secretaire)p);
			}
		}
		else {
			for(Personne pe : listChirurgien) {
				if(p.equals(pe)) {
					found = true;
				}
			}
			
			if(!found) {
				listChirurgien.add((Chirurgien)p);
				chirDAO.create((Chirurgien)p);
			}
		}
	}
	
	public void supprimerPersonnel(Personne p) {
		Secretaire foundSecr = null;
		Chirurgien foundChir = null;
		if(p instanceof Secretaire) {
			for(Secretaire s : listSecretaire) {
				if(p.equals(s)) {
					foundSecr = s;
				}
			}
			
			secrDAO.delete(foundSecr);
			listSecretaire.remove(foundSecr);
		}
		else {
			for(Chirurgien c : listChirurgien) {
				if(p.equals(c)) {
					foundChir = c;
				}
			}
			
			chirDAO.delete(foundChir);
			listChirurgien.remove(foundChir);
		}
	}

	// Cr�ation ou r�cup�ration de l'instance du singleton
	public static synchronized ListPersonnel getInstance() {
		if(instance == null)
			instance = new ListPersonnel();
		
		return instance;
	}
}
