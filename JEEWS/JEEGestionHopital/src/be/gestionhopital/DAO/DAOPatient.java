package be.gestionhopital.DAO;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.gestionhopital.Models.Patient;

public class DAOPatient extends DAO<Patient> {
	public DAOPatient(WebResource conn) {
		super(conn);
	}

	// Appel du Service Web (insertion d'un patient)
	@Override
	public boolean create(Patient obj) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("nom", obj.getNom());
		queryParams.add("prenom", obj.getPrenom());
		queryParams.add("dateNaiss", obj.getDateNaiss());
		queryParams.add("numTel", obj.getNumTelephone());
		queryParams.add("mdp", obj.getMotDePasse());
		queryParams.add("numChambre", obj.getNumChambre());
		queryParams.add("numPatient", obj.getNumPatient());
		
		ClientResponse response = connect.path("patient").type("application/x-www-form-urlencoded").post(ClientResponse.class, queryParams);
		
		obj.setIdPersonne(Integer.parseInt(response.getEntity(String.class)));
		
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}

	// Appel du Service Web (suppression d'un patient)
	@Override
	public boolean delete(Patient obj) {
		String id =  Integer.toString(obj.getIdPersonne());
		
		ClientResponse response = connect.path("patient/"+id).type("application/x-www-form-urlencoded").delete(ClientResponse.class);
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}

	// Appel du Service Web (mise � jour d'un patient)
	@Override
	public boolean update(Patient obj) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("id", Integer.toString(obj.getIdPersonne()));
		queryParams.add("nom", obj.getNom());
		queryParams.add("prenom", obj.getPrenom());
		queryParams.add("dateNaiss", obj.getDateNaiss());
		queryParams.add("numTel", obj.getNumTelephone());
		queryParams.add("mdp", obj.getMotDePasse());
		queryParams.add("numChambre", obj.getNumChambre());
		queryParams.add("numPatient", obj.getNumPatient());
		
		ClientResponse response = connect.path("patient").type("application/x-www-form-urlencoded").put(ClientResponse.class, queryParams);
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}

	// Appel du Service Web (r�cup�ration d'un patient)
	@Override
	public Patient find(int id) throws SAXException, IOException {
		String nom = null, prenom = null, numTel = null, mdp = null, numChambre = null, numPatient = null, dateNaiss = null;
		int idPers = 0;
		String responseText = connect.path("patient/"+id).accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(responseText));

		Document doc = db.parse(is);
		NodeList patientNodes = doc.getElementsByTagName("patient");
		
		for(int i = 0; i < patientNodes.getLength(); i++) {
				Element patient = (Element) patientNodes.item(i);
				
				NodeList idNode = patient.getElementsByTagName("id");
				Element line = (Element) idNode.item(0);
				idPers = Integer.parseInt(getCharacterDataFromElement(line));
				
				NodeList nomNode = patient.getElementsByTagName("nom");
				line = (Element) nomNode.item(0);
				nom = getCharacterDataFromElement(line);
				
				NodeList prenomNode = patient.getElementsByTagName("prenom");
				line = (Element) prenomNode.item(0);
				prenom = getCharacterDataFromElement(line);
				
				NodeList numTelNode = patient.getElementsByTagName("numTelephone");
				line = (Element) numTelNode.item(0);
				numTel = getCharacterDataFromElement(line);
				
				NodeList mdpNode = patient.getElementsByTagName("motDePasse");
				line = (Element) mdpNode.item(0);
				mdp = getCharacterDataFromElement(line);
				
				NodeList dateNaissNode = patient.getElementsByTagName("dateNaissance");
				line = (Element) dateNaissNode.item(0);
				dateNaiss = getCharacterDataFromElement(line);
				
				NodeList numChambreNode = patient.getElementsByTagName("numChambre");
				line = (Element) numChambreNode.item(0);
				numChambre = getCharacterDataFromElement(line);
				
				NodeList numPatientNode = patient.getElementsByTagName("numPatient");
				line = (Element) numPatientNode.item(0);
				numPatient = getCharacterDataFromElement(line);
		}
		
		return new Patient(numChambre, numPatient, idPers, nom, prenom, dateNaiss, numTel, mdp);
	}
	
	// Appel du Service Web (r�cup�ration de tous les patients)
	public List<Patient> findAll() throws ParserConfigurationException, SAXException, IOException{
		List<Patient> listPati = new ArrayList<>();
		String nom = null, prenom = null, numTel = null, mdp = null, numChambre = null, numPatient = null, dateNaiss = null;
		int id = 0;
		String responseText = connect.path("patient").accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(responseText));

		Document doc = db.parse(is);
		NodeList listPatientsNodes = doc.getElementsByTagName("listePatients");
		
		for(int i = 0; i < listPatientsNodes.getLength(); i++) {
			Element pati = (Element) listPatientsNodes.item(i);
			
			NodeList patientNodes = pati.getElementsByTagName("patient");
			
			for(int j = 0; j < patientNodes.getLength(); j++) {
				Element patient = (Element) patientNodes.item(j);
				
				NodeList idNode = patient.getElementsByTagName("id");
				Element line = (Element) idNode.item(0);
				id = Integer.parseInt(getCharacterDataFromElement(line));
				
				NodeList nomNode = patient.getElementsByTagName("nom");
				line = (Element) nomNode.item(0);
				nom = getCharacterDataFromElement(line);
				
				NodeList prenomNode = patient.getElementsByTagName("prenom");
				line = (Element) prenomNode.item(0);
				prenom = getCharacterDataFromElement(line);
				
				NodeList numTelNode = patient.getElementsByTagName("numTelephone");
				line = (Element) numTelNode.item(0);
				numTel = getCharacterDataFromElement(line);
				
				NodeList mdpNode = patient.getElementsByTagName("motDePasse");
				line = (Element) mdpNode.item(0);
				mdp = getCharacterDataFromElement(line);
				
				NodeList dateNaissNode = patient.getElementsByTagName("dateNaissance");
				line = (Element) dateNaissNode.item(0);
				dateNaiss = getCharacterDataFromElement(line);
				
				NodeList numChambreNode = patient.getElementsByTagName("numChambre");
				line = (Element) numChambreNode.item(0);
				numChambre = getCharacterDataFromElement(line);
				
				NodeList numPatientNode = patient.getElementsByTagName("numPatient");
				line = (Element) numPatientNode.item(0);
				numPatient = getCharacterDataFromElement(line);
				
				if(numChambre != null && numPatient != null && id != 0 && nom != null && prenom != null && dateNaiss != null && numTel != null)
					listPati.add(new Patient(numChambre, numPatient, id, nom, prenom, dateNaiss, numTel, mdp));
			}
		}
		
		return listPati;
	}
	
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData();
	    }
	    return "";
	  }
}
