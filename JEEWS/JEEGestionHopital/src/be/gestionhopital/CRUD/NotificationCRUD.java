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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.gestionhopital.Connexion.DriverACCESS;

@Path("notification")
public class NotificationCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getNotifications() throws SQLException {
		CallableStatement getNotif = null;
		ResultSet results = null;
		ResultSet obj = null;
		int i = 0;
		String retour = "<?xml version=\"1.0\"?>";
		
		retour += "<listeNotifications>";
		
		try{
			getNotif = conn.prepareCall("{ ? = call SelectAll.getNotifications() }");
			getNotif.registerOutParameter(1, Types.OTHER);
			getNotif.execute();
			while((results = (ResultSet)getNotif.getObject(1)) != null) {
				while((obj = (ResultSet)results.getObject(i)) != null) {
					while(results.next()) {
						retour += "<notification>";
						retour += "<id>"+results.getDouble("IdNotification")+"</id>";
						retour += "<priorite>"+results.getString("Priorite")+"</priorite>";
						retour += "<type>"+results.getString("Type_Notification")+"</type>";
						retour += "<commentaire>"+results.getDate("Commentaire")+"</commentaire>";
						retour += "<idPers>"+results.getString("IdPersonne")+"</idPers>";
						retour += "</notification>";
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
			if(getNotif != null)
				getNotif.close();
		}
		
		retour += "</listeNotifications>";
		
		return Response.status(Status.OK).entity(retour).build();
	}
	
	@POST
	public void insertNotification(@FormParam("priorite") String priorite, @FormParam("type") String type, @FormParam("commentaire") String commentaire, @FormParam("idPers") double idPers) throws SQLException {
		CallableStatement insertNotif = null;
		
		try {
			insertNotif = conn.prepareCall("{call Inserts.insertNotification(?,?,?,?)}");
			insertNotif.setString(1, priorite);
			insertNotif.setString(2, type);
			insertNotif.setString(3, commentaire);
			insertNotif.setDouble(4, idPers);
			insertNotif.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(insertNotif != null)
				insertNotif.close();
		}
	}
	
	@DELETE
	public void deleteNotification(@FormParam("id") int id) throws SQLException {
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