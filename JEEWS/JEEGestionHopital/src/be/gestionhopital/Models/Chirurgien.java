package be.gestionhopital.Models;

public class Chirurgien extends Personne{
	private static final long serialVersionUID = -6713247746739201921L;
	//Variable d'instance
	private String specialisation;
	
	//Constructeurs
	public Chirurgien() {
		super();
	}
	
	public Chirurgien(String specialisation,int idPersonne,String nom,String prenom,String dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.specialisation = specialisation;
	}
	
	//Propri�t�s
	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	
	//M�thodes
	@Override
	public void modifierInfos(Personne p) {
		super.modifierInfos(p);
		this.specialisation = ((Chirurgien)p).specialisation;
	};
	
	public void ajouterReservation(Reservation r) {
		ListReservation lr = ListReservation.getInstance();
		lr.ajouterReservation(r, null);
	}
	
	public void modifierReservation(Reservation before, Reservation after) {
		ListReservation lr = ListReservation.getInstance();
		lr.modifierReservation(before, after, null);
	}
	
	public void supprimerReservation(Reservation r) {
		ListReservation lr = ListReservation.getInstance();
		lr.supprimerReservation(r, null);
	}
	
	public void supprimerNotification(Notification n) {
		ListNotification ln = ListNotification.getInstance();
		ln.supprimerNotification(n);
	}
}
