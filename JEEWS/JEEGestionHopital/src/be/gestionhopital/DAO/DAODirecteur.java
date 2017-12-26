package be.gestionhopital.DAO;

import java.sql.Connection;

import be.gestionhopital.metier.Directeur;

public class DAODirecteur extends DAO<Directeur> {
	public DAODirecteur(Connection conn) {
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

	@Override
	public Directeur find(Directeur obj) {
		return null;
	}
}
