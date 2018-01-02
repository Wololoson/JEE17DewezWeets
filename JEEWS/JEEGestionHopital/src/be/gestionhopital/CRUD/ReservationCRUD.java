package be.gestionhopital.CRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.gestionhopital.Connexion.DriverACCESS;
import oracle.jdbc.internal.OracleTypes;

@Path("reservation")
public class ReservationCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	public ReservationCRUD() {}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getReservations() throws SQLException {
		CallableStatement getRes = null;
		ResultSet results = null;
		String retour = "<?xml version=\"1.0\"?>";
		
		retour += "<listeReservations>";
		
		try{
			getRes = conn.prepareCall("{ ? = call SelectAll.getReservations() }");
			getRes.registerOutParameter(1, OracleTypes.CURSOR);
			getRes.execute();
			if((results = (ResultSet)getRes.getObject(1)) != null) {
				while(results.next()) {
					retour += "<reservation>";
					retour += "<idPers>"+results.getInt("IdPersonne")+"</idPers>";
					retour += "<idSalle>"+results.getInt("IdSalle")+"</idSalle>";
					retour += "<numPatient>"+results.getInt("NumeroPatient")+"</numPatient>";
					retour += "<dateHeure>"+results.getDate("DateHeure")+"</dateHeure>";
					retour += "</reservation>";
				}
				results.close();
			}
			getRes.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getRes != null)
				getRes.close();
		}
		
		retour += "</listeReservations>";
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@POST
	public Response insertReservation(@FormParam("idPers") double idPers, @FormParam("idSalle") double idSalle, @FormParam("numPatient") double numPatient, @FormParam("dateHeure") Date dateHeure) throws SQLException {
		CallableStatement insertRes = null;
		
		try {
			insertRes = conn.prepareCall("{call Inserts.insertReservation(?,?,?,?)}");
			insertRes.setDouble(1, idPers);
			insertRes.setDouble(2, idSalle);
			insertRes.setDouble(3, numPatient);
			insertRes.setDate(4, dateHeure);
			insertRes.executeUpdate();
			return Response.status(200).entity(insertRes.getGeneratedKeys().toString()).build();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertRes != null)
				insertRes.close();
		}
		return Response.status(500).entity("ERROR").build();
	}
	
	@PUT
	public void updateReservation(@FormParam("idPers") double idPers, @FormParam("idSalle") double idSalle, @FormParam("numPatient") double numPatient, @FormParam("dateHeure") Date dateHeure) throws SQLException {
		CallableStatement updateRes = null;
		
		try {
			updateRes = conn.prepareCall("{call Updates.updateReservation(?,?,?,?)}");
			updateRes.setDouble(1, idPers);
			updateRes.setDouble(2, idSalle);
			updateRes.setDouble(3, numPatient);
			updateRes.setDate(4, dateHeure);
			updateRes.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(updateRes != null)
				updateRes.close();
		}
	}
	
	@DELETE
	public void deleteReservation(@FormParam("idPers") int idPers, @FormParam("idSalle") int idSalle, @FormParam("numPatient") int numPatient) throws SQLException {
		CallableStatement deleteRes = null;
		
		try {
			deleteRes = conn.prepareCall("{call Deletes.deleteNotification(?,?,?)}");
			deleteRes.setDouble(1, idPers);
			deleteRes.setDouble(2, idSalle);
			deleteRes.setDouble(3, numPatient);
			deleteRes.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(deleteRes != null)
				deleteRes.close();
		}
	}
}
