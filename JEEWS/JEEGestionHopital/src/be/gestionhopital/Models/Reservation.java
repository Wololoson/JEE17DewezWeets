package be.gestionhopital.Models;

import java.io.Serializable;
import java.sql.Date;

import be.gestionhopital.DAO.DAOSalle;
import be.gestionhopital.Factory.AbstractDAOFactory;

public class Reservation  implements Serializable {
	private static final long serialVersionUID = 2406742677558119343L;
	//Variables d'instance
	private int idReservation;
	private Chirurgien chirurgien;
	private Salle salle;
	private Patient patient;
	private Date dateRes;
	private String heureRes;
	
	//Constructeurs
	public Reservation() {
		
	}
	
	public Reservation(int idReservation, Chirurgien chirurgien,Salle salle,Patient patient,Date dateRes,String heureRes) {
		this.idReservation = idReservation;
		this.chirurgien = chirurgien;
		this.salle = salle;
		this.patient = patient;
		this.dateRes = dateRes;
		this.heureRes = heureRes;
	}

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	//Propriétés
	public Chirurgien getChirurgien() {
		return chirurgien;
	}

	public void setChirurgien(Chirurgien chirurgien) {
		this.chirurgien = chirurgien;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Date getDateRes() {
		return dateRes;
	}

	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
	}

	public String getHeureRes() {
		return heureRes;
	}

	public void setHeureRes(String heureRes) {
		this.heureRes = heureRes;
	}

	public void modifierReservation(Reservation r) {
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAOSalle salleDAO = (DAOSalle)adf.getSalleDAO();
		ListPatient lp = ListPatient.getInstance();
		
		this.chirurgien = r.getChirurgien();
		
		lp.ajouterPatient(r.getPatient());
		salleDAO.create(r.getSalle());
		
		this.dateRes = r.getDateRes();
		this.heureRes = r.getHeureRes();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chirurgien == null) ? 0 : chirurgien.hashCode());
		result = prime * result + ((dateRes == null) ? 0 : dateRes.hashCode());
		result = prime * result + ((heureRes == null) ? 0 : heureRes.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((salle == null) ? 0 : salle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (chirurgien == null) {
			if (other.chirurgien != null)
				return false;
		} else if (!chirurgien.equals(other.chirurgien))
			return false;
		if (dateRes == null) {
			if (other.dateRes != null)
				return false;
		} else if (!dateRes.equals(other.dateRes))
			return false;
		if (heureRes == null) {
			if (other.heureRes != null)
				return false;
		} else if (!heureRes.equals(other.heureRes))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		return true;
	}


}
