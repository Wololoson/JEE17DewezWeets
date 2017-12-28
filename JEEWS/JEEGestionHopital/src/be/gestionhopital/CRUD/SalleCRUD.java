package be.gestionhopital.CRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
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

@Path("salle")
public class SalleCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response getSalle(@PathParam("id") int id) throws SQLException {
		String retour = "";
		CallableStatement getSalle = null;
		ResultSet results = null;
		
		try {
			getSalle = conn.prepareCall("{ ? = call SelectOne.getSalle(?)}");
			getSalle.registerOutParameter(1, Types.OTHER);
			getSalle.setDouble(2, id);
			getSalle.execute();
			results = (ResultSet)getSalle.getObject(1);
			if(results.next()) {
				retour += "<salle>";
				retour += "<id>"+results.getDouble("IdSalle")+"</id>";
				retour += "<numero>"+results.getString("Numero")+"</numero>";
				retour += "<blocSalle>"+results.getString("Bloc_Salle")+"</blocSalle>";
				retour += "</salle>";
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getSalle != null)
				getSalle.close();
		}
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@POST
	public void insertSalle(@FormParam("num") String num, @FormParam("bloc") String bloc) throws SQLException {
		CallableStatement insertSalle = null;
		
		try {
			insertSalle = conn.prepareCall("{call Inserts.insertSalle(?,?)}");
			insertSalle.setString(1, num);
			insertSalle.setString(2, bloc);
			insertSalle.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertSalle != null)
				insertSalle.close();
		}
	}
	
	@PUT
	public void updateSalle(@FormParam("num") String num, @FormParam("bloc") String bloc) throws SQLException {
		CallableStatement updateSalle = null;
		
		try {
			updateSalle = conn.prepareCall("{call Updates.updateSalle(?,?)}");
			updateSalle.setString(1, num);
			updateSalle.setString(2, bloc);
			updateSalle.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(updateSalle != null)
				updateSalle.close();
		}
	}
	
	@DELETE
	public void deleteSalle(@FormParam("id") int id) throws SQLException {
		CallableStatement deleteSalle = null;
		
		try {
			deleteSalle = conn.prepareCall("{call Deletes.deleteSalle(?)}");
			deleteSalle.setDouble(1, id);
			deleteSalle.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(deleteSalle != null)
				deleteSalle.close();
		}
	}
}