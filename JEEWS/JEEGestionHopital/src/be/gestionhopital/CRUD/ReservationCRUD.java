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
import javax.ws.rs.PathParam;
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
	
	// Récupération de toutes les réservations
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
					retour += "<idReservation>"+results.getInt("IdReservation")+"</idReservation>";
					retour += "<idPers>"+results.getInt("IdPersonne")+"</idPers>";
					retour += "<idSalle>"+results.getInt("IdSalle")+"</idSalle>";
					retour += "<numPatient>"+results.getInt("NumeroPatient")+"</numPatient>";
					retour += "<dateRes>"+results.getDate("DateRes")+"</dateRes>";
					retour += "<heureRes>"+results.getString("HeureRes")+"</heureRes>";
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
	
	// Insertion d'une réservation
	@POST
	public void insertReservation(@FormParam("idChirurgien") double idPers, @FormParam("idSalle") double idSalle, @FormParam("numPatient") String numPatient, @FormParam("dateRes") Date dateRes, @FormParam("heureRes") String heureRes) throws SQLException {
		CallableStatement insertRes = null;
		
		try {
			insertRes = conn.prepareCall("{call Inserts.insertReservation(?,?,?,?,?)}");
			insertRes.setDouble(1, idPers);
			insertRes.setDouble(2, idSalle);
			insertRes.setString(3, numPatient);
			insertRes.setDate(4, dateRes);
			insertRes.setString(5, heureRes);
			insertRes.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertRes != null)
				insertRes.close();
		}
	}
	
	// Mise à jour d'une réservation
	@PUT
	public void updateReservation(@FormParam("id") int id, @FormParam("idChirurgien") double idPers, @FormParam("idSalle") double idSalle, @FormParam("numPatient") String numPatient, @FormParam("dateRes") Date dateRes, @FormParam("heureRes") String heureRes) throws SQLException {
		CallableStatement updateRes = null;
		
		try {
			updateRes = conn.prepareCall("{call Updates.updateReservation(?,?,?,?,?,?)}");
			updateRes.setInt(1, id);
			updateRes.setDouble(2, idPers);
			updateRes.setDouble(3, idSalle);
			updateRes.setString(4, numPatient);
			updateRes.setDate(5, dateRes);
			updateRes.setString(6, heureRes);
			updateRes.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(updateRes != null)
				updateRes.close();
		}
	}
	
	// Suppression d'une réservation
	@DELETE
	@Path("{id}")
	public Response deleteReservation(@PathParam("id") int id) throws SQLException {
		CallableStatement deleteRes = null;
		
		try {
			deleteRes = conn.prepareCall("{call Deletes.deleteReservation(?)}");
			deleteRes.setDouble(1, id);
			deleteRes.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(deleteRes != null)
				deleteRes.close();
		}
		
		return Response.status(Status.OK).build();
	}
}
