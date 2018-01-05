package be.gestionhopital.Models;

public class Directeur extends Personne {
	private static final long serialVersionUID = 1457950990267848045L;
	// Variable d'instance
	private String code;

	// Constructeurs
	public Directeur() {
		super();
	}
	
	public Directeur(String code,int idPersonne,String nom,String prenom,String dateNaiss, String numTelephone, String motDePasse) {
		super(idPersonne,nom,prenom,dateNaiss,numTelephone,motDePasse);
		this.code = code;
	}

	// Propri�t�s
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// M�thodes
	@Override
	public void modifierInfos(Personne p) {};
	
	public void ajouterPersonnel(Personne p) {
		ListPersonnel lp = ListPersonnel.getInstance();
		lp.ajouterPersonnel(p);
	}
	
	public void supprimerPersonnel(Personne p) {
		ListPersonnel lp = ListPersonnel.getInstance();
		lp.supprimerPersonnel(p);
	}
}
