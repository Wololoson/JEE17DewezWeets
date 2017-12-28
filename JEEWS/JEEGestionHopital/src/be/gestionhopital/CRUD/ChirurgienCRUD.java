package be.gestionhopital.CRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

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

@Path("chirurgien")
public class ChirurgienCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getChirurgiens() throws SQLException {
		CallableStatement getChir = null;
		ResultSet results = null;
		ResultSet obj = null;
		int i = 0;
		String retour = "<?xml version=\"1.0\"?>";
		
		retour += "<listeChirurgiens>";
		
		try{
			getChir = conn.prepareCall("{ ? = call SelectAll.getChirurgiens }");
			getChir.registerOutParameter(1, OracleTypes.PLSQL_INDEX_TABLE); //java.sql.SQLException: Param�tre IN ou OUT absent dans l'index :: 1
			getChir.execute();
			while((results = (ResultSet)getChir.getObject(1)) != null) {
				while((obj = (ResultSet)results.getObject(i)) != null) {
					while(obj.next()) {
						retour += "<chirurgien>";
						retour += "<id>"+results.getDouble("IdPersonne")+"</id>";
						retour += "<nom>"+results.getString("Nom")+"</nom>";
						retour += "<prenom>"+results.getString("Prenom")+"</prenom>";
						retour += "<dateNaissance>"+results.getDate("DateNaissance")+"</dateNaissance>";
						retour += "<numTelephone>"+results.getString("NumeroTelephone")+"</numTelephone>";
						retour += "<motDePasse>"+results.getString("MotDePasse")+"</motDePasse>";
						retour += "<specialisation>"+results.getString("Specialisation")+"</specialisation>";
						retour += "</chirurgien>";
					}
				}
				i++;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(obj != null)
				obj.close();
			if(results != null)
				results.close();
			if(getChir != null)
				getChir.close();
		}
		
		retour += "</listeChirurgiens>";
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response getChirurgien(@PathParam("id") int id) throws SQLException {
		String retour = "";
		CallableStatement getChir = null;
		ResultSet results = null;
		
		try {
			getChir = conn.prepareCall("{ ? = call SelectOne.getChirurgien(?)}");
			getChir.registerOutParameter(1, Types.OTHER);
			getChir.setDouble(2, id);
			getChir.execute();
			results = (ResultSet)getChir.getObject(1);
			if(results.next()) {
				retour += "<chirurgien>";
				retour += "<id>"+results.getDouble("IdPersonne")+"</id>";
				retour += "<nom>"+results.getString("Nom")+"</nom>";
				retour += "<prenom>"+results.getString("Prenom")+"</prenom>";
				retour += "<dateNaissance>"+results.getDate("DateNaissance")+"</dateNaissance>";
				retour += "<numTelephone>"+results.getString("NumeroTelephone")+"</numTelephone>";
				retour += "<motDePasse>"+results.getString("MotDePasse")+"</motDePasse>";
				retour += "<specialisation>"+results.getString("Specialisation")+"</specialisation>";
				retour += "</chirurgien>";
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getChir != null)
				getChir.close();
		}
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@POST
	public void insertChirurgien(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("dateNaiss") String dateNaiss, @FormParam("numTel") String numTel, @FormParam("mdp") String mdp, @FormParam("spec") String spec) throws SQLException {
		CallableStatement insertChir = null;
		
		try {
			insertChir = conn.prepareCall("{call Inserts.insertChirurgien(?,?,?,?,?,?)}");
			insertChir.setString(1, nom);
			insertChir.setString(2, prenom);
			insertChir.setDate(3, Date.valueOf(dateNaiss));
			insertChir.setString(4, numTel);
			insertChir.setString(5, mdp);
			insertChir.setString(6, spec);
			insertChir.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertChir != null)
				insertChir.close();
		}
	}
	
	@PUT
	public void updateChirurgien(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("dateNaiss") String dateNaiss, @FormParam("numTel") String numTel, @FormParam("mdp") String mdp, @FormParam("spec") String spec) throws SQLException {
		CallableStatement updateChir = null;
		
		try {
			updateChir = conn.prepareCall("{call Updates.updateChirurgien(?,?,?,?,?,?)}");
			updateChir.setString(1, nom);
			updateChir.setString(2, prenom);
			updateChir.setDate(3, Date.valueOf(dateNaiss));
			updateChir.setString(4, numTel);
			updateChir.setString(5, mdp);
			updateChir.setString(6, spec);
			updateChir.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(updateChir != null)
				updateChir.close();
		}
	}
	
	@DELETE
	public void deleteChirurgien(@FormParam("id") int id) throws SQLException {
		CallableStatement deleteDire = null;
		
		try {
			deleteDire = conn.prepareCall("{call Deletes.deleteChirurgien(?)}");
			deleteDire.setDouble(1, id);
			deleteDire.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(deleteDire != null)
				deleteDire.close();
		}
	}
}