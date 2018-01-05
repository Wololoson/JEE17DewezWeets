package be.gestionhopital.CRUD;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
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

@Path("patient")
public class PatientCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	public PatientCRUD() {}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getPatients() throws SQLException {
		CallableStatement getPati = null;
		ResultSet results = null;
		String retour = "<?xml version=\"1.0\"?>";
		
		retour += "<listePatients>";
		
		try{
			getPati = conn.prepareCall("{ ? = call SelectAll.getPatients() }");
			getPati.registerOutParameter(1, OracleTypes.CURSOR);
			getPati.execute();
			if((results = (ResultSet)getPati.getObject(1)) != null) {
				while(results.next()) {
					retour += "<patient>";
					retour += "<id>"+results.getInt("IdPersonne")+"</id>";
					retour += "<nom>"+results.getString("Nom")+"</nom>";
					retour += "<prenom>"+results.getString("Prenom")+"</prenom>";
					retour += "<dateNaissance>"+results.getString("DateNaissance")+"</dateNaissance>";
					retour += "<numTelephone>"+results.getString("NumeroTelephone")+"</numTelephone>";
					retour += "<motDePasse>"+results.getString("MotDePasse")+"</motDePasse>";
					retour += "<numChambre>"+results.getString("NumeroChambre")+"</numChambre>";
					retour += "<numPatient>"+results.getString("NumeroPatient")+"</numPatient>";
					retour += "</patient>";
				}
				results.close();
			}
			getPati.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getPati != null)
				getPati.close();
		}
		
		retour += "</listePatients>";
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response getPatient(@PathParam("id") int id) throws SQLException {
		String retour = "";
		CallableStatement getPati = null;
		ResultSet results = null;
		
		try {
			getPati = conn.prepareCall("{ ? = call SelectOne.getPatient(?)}");
			getPati.registerOutParameter(1, OracleTypes.CURSOR);
			getPati.setDouble(2, id);
			getPati.execute();
			results = (ResultSet)getPati.getObject(1);
			if(results.next()) {
				retour += "<patient>";
				retour += "<id>"+results.getInt("IdPersonne")+"</id>";
				retour += "<nom>"+results.getString("Nom")+"</nom>";
				retour += "<prenom>"+results.getString("Prenom")+"</prenom>";
				retour += "<dateNaissance>"+results.getString("DateNaissance")+"</dateNaissance>";
				retour += "<numTelephone>"+results.getString("NumeroTelephone")+"</numTelephone>";
				retour += "<motDePasse>"+results.getString("MotDePasse")+"</motDePasse>";
				retour += "<numChambre>"+results.getString("NumeroChambre")+"</numChambre>";
				retour += "<numPatient>"+results.getString("NumeroPatient")+"</numPatient>";
				retour += "</patient>";
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getPati != null)
				getPati.close();
		}
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertPatient(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("dateNaiss") String dateNaiss, @FormParam("numTel") String numTel, @FormParam("mdp") String mdp, @FormParam("numChambre") String numCh, @FormParam("numPatient") String numPa) throws SQLException {
		CallableStatement insertPati = null;
		BigDecimal tmp;
		String id = null;
		
		try {
			insertPati = conn.prepareCall("{? = call Inserts.insertPatient(?,?,?,?,?,?,?)}");
			insertPati.registerOutParameter(1, OracleTypes.NUMBER);
			insertPati.setString(2, nom);
			insertPati.setString(3, prenom);
			insertPati.setString(4, dateNaiss);
			insertPati.setString(5, numTel);
			insertPati.setString(6, mdp);
			insertPati.setString(7, numCh);
			insertPati.setString(8, numPa);
			insertPati.executeUpdate();
			
			tmp = (BigDecimal)insertPati.getObject(1);
			id = tmp.toString();
			
			return Response.status(Status.OK).entity(id).build();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertPati != null)
				insertPati.close();
		}
		return Response.status(500).entity("ERROR").build();
	}
	
	@PUT
	public void updatePatient(@FormParam("id") int id, @FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("dateNaiss") String dateNaiss, @FormParam("numTel") String numTel, @FormParam("mdp") String mdp, @FormParam("numCh") String numCh, @FormParam("numPa") String numPa) throws SQLException {
		CallableStatement updatePati = null;
		
		try {
			updatePati = conn.prepareCall("{call Updates.updatePatient(?,?,?,?,?,?,?,?)}");
			updatePati.setInt(1, id);
			updatePati.setString(2, nom);
			updatePati.setString(3, prenom);
			updatePati.setString(4, dateNaiss);
			updatePati.setString(5, numTel);
			updatePati.setString(6, mdp);
			updatePati.setString(7, numCh);
			updatePati.setString(8, numPa);
			updatePati.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(updatePati != null)
				updatePati.close();
		}
	}
	
	@DELETE
	@Path("{id}")
	public void deletePatient(@PathParam("id") int id) throws SQLException {
		CallableStatement deletePati = null;
		
		try {
			deletePati = conn.prepareCall("{call Deletes.deletePatient(?)}");
			deletePati.setDouble(1, id);
			deletePati.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(deletePati != null)
				deletePati.close();
		}
	}
}
