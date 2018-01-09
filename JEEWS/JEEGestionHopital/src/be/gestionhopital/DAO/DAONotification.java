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

import be.gestionhopital.Factory.AbstractDAOFactory;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.Notification;

public class DAONotification extends DAO<Notification> {
	public DAONotification(WebResource conn) {
		super(conn);
	}

	// Appel du Service Web (insertion d'une notification)
	@Override
	public boolean create(Notification obj) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("priorite", Integer.toString(obj.getPriorite()));
		queryParams.add("type", Integer.toString(obj.getType()));
		queryParams.add("commentaire", obj.getCommentaire());
		queryParams.add("idChirurgien", Integer.toString(obj.getChirurgien().getIdPersonne()));
		
		ClientResponse response = connect.path("notification").type("application/x-www-form-urlencoded").post(ClientResponse.class, queryParams);
		
		obj.setIdNotification(Integer.parseInt(response.getEntity(String.class)));
		
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}

	// Appel du Service Web (suppression d'une notification)
	@Override
	public boolean delete(Notification obj) {
		String id =  Integer.toString(obj.getIdNotification());
		
		ClientResponse response = connect.path("notification/"+id).type("application/x-www-form-urlencoded").delete(ClientResponse.class);
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Appel du Service Web (suppression de toutes les notifications)
	public boolean deleteAll() {
		
		ClientResponse response = connect.path("notification").type("application/x-www-form-urlencoded").delete(ClientResponse.class);
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}

	// Appel du Service Web (mise à jour d'une notification)
	@Override
	public boolean update(Notification obj) {
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("id", Integer.toString(obj.getIdNotification()));
		queryParams.add("priorite", Integer.toString(obj.getPriorite()));
		queryParams.add("type", Integer.toString(obj.getType()));
		queryParams.add("commentaire", obj.getCommentaire());
		queryParams.add("idChirurgien", Integer.toString(obj.getChirurgien().getIdPersonne()));
		
		ClientResponse response = connect.path("notification").type("application/x-www-form-urlencoded").put(ClientResponse.class, queryParams);
		if(response.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Notification find(int id) {
		return null;
	}
	
	// Appel du Service Web (récupération de toutes les notifications)
	public List<Notification> findAll() throws ParserConfigurationException, SAXException, IOException{
		List<Notification> listNoti = new ArrayList<>();
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Chirurgien> DAOChirurgien = adf.getChirurgienDAO();
		String commentaire = null, idPers = null;
		int id = 0, priorite = 0, type = 0;
		Chirurgien chir = null;
		String responseText = connect.path("notification").accept(MediaType.TEXT_XML).get(String.class);
		
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(responseText));

		Document doc = db.parse(is);
		NodeList listNotificationsNodes = doc.getElementsByTagName("listeNotifications");
		
		for(int i = 0; i < listNotificationsNodes.getLength(); i++) {
			Element noti = (Element) listNotificationsNodes.item(i);
			
			NodeList notificationNodes = noti.getElementsByTagName("notification");
			
			for(int j = 0; j < notificationNodes.getLength(); j++) {
				Element notification = (Element) notificationNodes.item(j);
				
				NodeList idNode = notification.getElementsByTagName("id");
				Element line = (Element) idNode.item(0);
				id = Integer.parseInt(getCharacterDataFromElement(line));
				
				NodeList prioriteNode = notification.getElementsByTagName("priorite");
				line = (Element) prioriteNode.item(0);
				priorite = Integer.parseInt(getCharacterDataFromElement(line));
				
				NodeList typeNode = notification.getElementsByTagName("type");
				line = (Element) typeNode.item(0);
				type = Integer.parseInt(getCharacterDataFromElement(line));
				
				NodeList commentaireNode = notification.getElementsByTagName("commentaire");
				line = (Element) commentaireNode.item(0);
				commentaire = getCharacterDataFromElement(line);
				
				NodeList chirNode = notification.getElementsByTagName("idPers");
				line = (Element) chirNode.item(0);
				idPers = getCharacterDataFromElement(line);
				chir = DAOChirurgien.find(Integer.parseInt(idPers));
				
				if(priorite != 0 && id != 0 && type != 0 && commentaire != null && chir != null)
					listNoti.add(new Notification(id, priorite, type, commentaire, chir));
			}
		}
		
		return listNoti;
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
