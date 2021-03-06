package be.gestionhopital.DAO;

import java.io.IOException;
import java.io.StringReader;

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.WebResource;

import be.gestionhopital.Models.Directeur;

public class DAODirecteur extends DAO<Directeur> {
	public DAODirecteur(WebResource conn) {
		super(conn);
	}

	@Override
	public boolean create(Directeur obj) {
		return false;
	}

	@Override
	public boolean delete(Directeur obj) {
		return false;
	}

	@Override
	public boolean update(Directeur obj) {
		return false;
	}

	// Appel du Service Web (récupération du directeur)
	@Override
	public Directeur find(int id) throws SAXException, IOException {
		Directeur dire = null;
		String nom = null, prenom = null, numTel = null, mdp = null, code = null, dateNaiss = null;
		int idPers = 0;
		String responseText = connect.path("directeur").accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(responseText));

		Document doc = db.parse(is);
		NodeList listDirecteurNodes = doc.getElementsByTagName("listeDirecteurs");
		
		for(int i = 0; i < listDirecteurNodes.getLength(); i++) {
			Element chir = (Element) listDirecteurNodes.item(i);
			
			NodeList directeurNodes = chir.getElementsByTagName("directeur");
			
			for(int j = 0; j < directeurNodes.getLength(); j++) {
				Element directeur = (Element) directeurNodes.item(j);
				
				NodeList idNode = directeur.getElementsByTagName("id");
				Element line = (Element) idNode.item(0);
				idPers = Integer.parseInt(getCharacterDataFromElement(line));
				
				NodeList nomNode = directeur.getElementsByTagName("nom");
				line = (Element) nomNode.item(0);
				nom = getCharacterDataFromElement(line);
				
				NodeList prenomNode = directeur.getElementsByTagName("prenom");
				line = (Element) prenomNode.item(0);
				prenom = getCharacterDataFromElement(line);
				
				NodeList dateNaissNode = directeur.getElementsByTagName("dateNaissance");
				line = (Element) dateNaissNode.item(0);
				dateNaiss = getCharacterDataFromElement(line);
				
				NodeList numTelNode = directeur.getElementsByTagName("numTelephone");
				line = (Element) numTelNode.item(0);
				numTel = getCharacterDataFromElement(line);
				
				NodeList mdpNode = directeur.getElementsByTagName("motDePasse");
				line = (Element) mdpNode.item(0);
				mdp = getCharacterDataFromElement(line);
				
				NodeList codeNode = directeur.getElementsByTagName("code");
				line = (Element) codeNode.item(0);
				code = getCharacterDataFromElement(line);
			}
			
			dire = new Directeur(code, idPers, nom, prenom, dateNaiss, numTel, mdp);
		}
		
		return dire;
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
