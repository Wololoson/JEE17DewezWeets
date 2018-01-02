package be.gestionhopital.Models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import be.gestionhopital.DAO.DAOPatient;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class ListPatient implements Serializable {
	private static final long serialVersionUID = -8613172557670583L;
	private static ListPatient instance = null;
	private List<Patient> listPatient = new ArrayList<>();
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAOPatient patiDAO = (DAOPatient) adf.getPatientDAO();
	
	private ListPatient() {
		try {
			listPatient = patiDAO.findAll();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Patient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<Patient> listPatient) {
		this.listPatient = listPatient;
	}

	public void ajouterPatient(Patient p) {
		boolean found = false;
		for(Patient pa : listPatient) {
			if(p.equals(pa)) 
				found = true;
		}
		
		if(!found) {
			listPatient.add(p);
			patiDAO.create(p);
		}
	}
	
	public void supprimerPatient(Patient p) {
		for(Patient pa : listPatient) {
			if(p.equals(pa)) {
				patiDAO.delete(pa);
				listPatient.remove(pa);
			}
		}
	}
	
	public static synchronized ListPatient getInstance() {
		if(instance == null)
			instance = new ListPatient();
		
		return instance;
	}
}
