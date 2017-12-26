package be.gestionhopital.DAO;

import java.sql.Connection;

import be.gestionhopital.metier.Patient;

public class DAOPatient extends DAO<Patient> {
	public DAOPatient(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Patient obj) {
		return false;
	}

	@Override
	public boolean delete(Patient obj) {
		return false;
	}

	@Override
	public boolean update(Patient obj) {
		return false;
	}

	@Override
	public Patient find(Patient obj) {
		return null;
	}
}
