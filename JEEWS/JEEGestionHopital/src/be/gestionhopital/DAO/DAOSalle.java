package be.gestionhopital.DAO;

import java.sql.Connection;

import be.gestionhopital.metier.Salle;

public class DAOSalle extends DAO<Salle> {
	public DAOSalle(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Salle obj) {
		return false;
	}

	@Override
	public boolean delete(Salle obj) {
		return false;
	}

	@Override
	public boolean update(Salle obj) {
		return false;
	}

	@Override
	public Salle find(Salle obj) {
		return null;
	}
}