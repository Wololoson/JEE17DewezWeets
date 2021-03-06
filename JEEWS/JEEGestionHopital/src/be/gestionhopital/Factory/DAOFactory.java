package be.gestionhopital.Factory;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import be.gestionhopital.DAO.DAO;
import be.gestionhopital.DAO.DAOChirurgien;
import be.gestionhopital.DAO.DAODirecteur;
import be.gestionhopital.DAO.DAONotification;
import be.gestionhopital.DAO.DAOPatient;
import be.gestionhopital.DAO.DAOReservation;
import be.gestionhopital.DAO.DAOSalle;
import be.gestionhopital.DAO.DAOSecretaire;
import be.gestionhopital.Models.Chirurgien;
import be.gestionhopital.Models.Directeur;
import be.gestionhopital.Models.Notification;
import be.gestionhopital.Models.Patient;
import be.gestionhopital.Models.Reservation;
import be.gestionhopital.Models.Salle;
import be.gestionhopital.Models.Secretaire;

// Classe du patterne Factory
public class DAOFactory extends AbstractDAOFactory {
	protected static final ClientConfig config = new DefaultClientConfig();
	protected static final Client client = Client.create(config);
	protected static final WebResource service = client.resource(getBaseURI());

	@Override
	public DAO<Chirurgien> getChirurgienDAO() {
		return new DAOChirurgien(service);
	}

	@Override
	public DAO<Directeur> getDirecteurDAO() {
		return new DAODirecteur(service);
	}

	@Override
	public DAO<Notification> getNotificationDAO() {
		return new DAONotification(service);
	}

	@Override
	public DAO<Patient> getPatientDAO() {
		return new DAOPatient(service);
	}

	@Override
	public DAO<Reservation> getReservationDAO() {
		return new DAOReservation(service);
	}

	@Override
	public DAO<Salle> getSalleDAO() {
		return new DAOSalle(service);
	}

	@Override
	public DAO<Secretaire> getSecretaireDAO() {
		return new DAOSecretaire(service);
	}
	
	// URI de base du service Web
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:9090/JEEGestionHopital/rest").build();
	}
}
