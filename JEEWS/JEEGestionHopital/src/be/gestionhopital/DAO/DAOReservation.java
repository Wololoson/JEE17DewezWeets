package be.gestionhopital.DAO;

import java.sql.Connection;

import be.gestionhopital.metier.Reservation;

public class DAOReservation extends DAO<Reservation> {
	public DAOReservation(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Reservation obj) {
		return false;
	}

	@Override
	public boolean delete(Reservation obj) {
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		return false;
	}

	@Override
	public Reservation find(Reservation obj) {
		return null;
	}
}