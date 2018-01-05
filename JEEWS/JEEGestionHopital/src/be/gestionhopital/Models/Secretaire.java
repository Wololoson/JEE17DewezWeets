package be.gestionhopital.Models;

public class Secretaire extends Personne {
	private static final long serialVersionUID = 3955384103009827636L;
	// Variable d'instance
	private String service;

	// Constructeurs
	public Secretaire() {
		super();
	}
	
	public Secretaire(String service,int idPersonne,String nom,String prenom,String dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.service = service;
	}

	// Propri�t�s
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	// M�thodes
	@Override
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.service = ((Secretaire)p).service;
	};
	
	public void ajouterReservation(Reservation r, Notification n) {
		ListReservation lr = ListReservation.getInstance();
		lr.ajouterReservation(r, n);
	}
	
	public void modifierReservation(Reservation before, Reservation after, Notification n) {
		ListReservation lr = ListReservation.getInstance();
		lr.modifierReservation(before, after, n);
	}
	
	public void supprimerReservation(Reservation r, Notification n) {
		ListReservation lr = ListReservation.getInstance();
		lr.supprimerReservation(r, n);
	}
}
