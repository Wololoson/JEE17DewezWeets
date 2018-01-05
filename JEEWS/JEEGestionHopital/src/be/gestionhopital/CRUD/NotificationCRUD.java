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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.gestionhopital.Connexion.DriverACCESS;
import oracle.jdbc.internal.OracleTypes;

@Path("notification")
public class NotificationCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	public NotificationCRUD() {}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getNotifications() throws SQLException {
		CallableStatement getNotif = null;
		ResultSet results = null;
		String retour = "<?xml version=\"1.0\"?>";
		
		retour += "<listeNotifications>";
		
		try{
			getNotif = conn.prepareCall("{ ? = call SelectAll.getNotifications() }");
			getNotif.registerOutParameter(1, OracleTypes.CURSOR);
			getNotif.execute();
			if((results = (ResultSet)getNotif.getObject(1)) != null) {
				while(results.next()) {
					retour += "<notification>";
					retour += "<id>"+results.getInt("IdNotification")+"</id>";
					retour += "<priorite>"+results.getInt("Priorite")+"</priorite>";
					retour += "<type>"+results.getInt("Type_Notif")+"</type>";
					retour += "<commentaire>"+results.getString("Commentaire")+"</commentaire>";
					retour += "<idPers>"+results.getInt("IdPersonne")+"</idPers>";
					retour += "</notification>";
				}
				results.close();
			}
			getNotif.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getNotif != null)
				getNotif.close();
		}
		
		retour += "</listeNotifications>";
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertNotification(@FormParam("priorite") String priorite, @FormParam("type") String type, @FormParam("commentaire") String commentaire, @FormParam("idChirurgien") double idPers) throws SQLException {
		CallableStatement insertNotif = null;
		BigDecimal tmp;
		String id = null;
		
		try {
			insertNotif = conn.prepareCall("{? = call Inserts.insertNotification(?,?,?,?)}");
			insertNotif.registerOutParameter(1, OracleTypes.NUMBER);
			insertNotif.setString(2, priorite);
			insertNotif.setString(3, type);
			insertNotif.setString(4, commentaire);
			insertNotif.setDouble(5, idPers);
			insertNotif.executeUpdate();

			tmp = (BigDecimal)insertNotif.getObject(1);
			id = tmp.toString();
			
			return Response.status(200).entity(id).build();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertNotif != null)
				insertNotif.close();
		}
		return Response.status(500).entity("ERROR").build();
	}
	
	@DELETE
	@Path("{id}")
	public void deleteNotification(@PathParam("id") int id) throws SQLException {
		CallableStatement deleteNotif = null;
		
		try {
			deleteNotif = conn.prepareCall("{call Deletes.deleteNotification(?)}");
			deleteNotif.setDouble(1, id);
			deleteNotif.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(deleteNotif != null)
				deleteNotif.close();
		}
	}
}
