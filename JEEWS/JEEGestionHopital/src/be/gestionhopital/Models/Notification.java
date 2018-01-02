package be.gestionhopital.Models;

import java.io.Serializable;

public class Notification implements Serializable{
	private static final long serialVersionUID = -8960616417745224950L;
	//Variables d'instance
	private int idNotification;
	private int priorite;
	private int type;
	private String commentaire;
	private Chirurgien chirurgien;
	
	//Constructeurs
	public Notification() {
		
	}
	
	public Notification(int idNotification,int priorite,int type,String commentaire,Chirurgien chirurgien) {
		this.idNotification = idNotification;
		this.priorite = priorite;
		this.type = type;
		this.commentaire = commentaire;
		this.chirurgien = chirurgien;
	}

	//Propriétés
	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Chirurgien getChirurgien() {
		return chirurgien;
	}

	public void setChirurgien(Chirurgien chirurgien) {
		this.chirurgien = chirurgien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chirurgien == null) ? 0 : chirurgien.hashCode());
		result = prime * result + ((commentaire == null) ? 0 : commentaire.hashCode());
		result = prime * result + idNotification;
		result = prime * result + priorite;
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Notification other = (Notification) obj;
		if (chirurgien == null) {
			if (other.chirurgien != null)
				return false;
		}
		if (!chirurgien.equals(other.chirurgien))
			return false;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
		if (idNotification != other.idNotification)
			return false;
		if (priorite != other.priorite)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
