package be.gestionhopital.CRUD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.gestionhopital.Connexion.DriverACCESS;
import oracle.jdbc.internal.OracleTypes;

@Path("directeur")
public class DirecteurCRUD {
	private Connection conn = DriverACCESS.getInstance();
	
	public DirecteurCRUD() {}
	
	// Récupération du directeur
	@GET
	@Produces(MediaType.TEXT_XML)
	public Response getDirecteurs() throws SQLException {
		CallableStatement getDire = null;
		ResultSet results = null;
		String retour = "<?xml version=\"1.0\"?>";
		
		retour += "<listeDirecteurs>";
		
		try{
			getDire = conn.prepareCall("{ ? = call SelectAll.getDirecteurs() }");
			getDire.registerOutParameter(1, OracleTypes.CURSOR);
			getDire.execute();
			if((results = (ResultSet)getDire.getObject(1)) != null) {
				while(results.next()) {
					retour += "<directeur>";
					retour += "<id>"+results.getInt("IdPersonne")+"</id>";
					retour += "<nom>"+results.getString("Nom")+"</nom>";
					retour += "<prenom>"+results.getString("Prenom")+"</prenom>";
					retour += "<dateNaissance>"+results.getString("DateNaissance")+"</dateNaissance>";
					retour += "<numTelephone>"+results.getString("NumeroTelephone")+"</numTelephone>";
					retour += "<motDePasse>"+results.getString("MotDePasse")+"</motDePasse>";
					retour += "<code>"+results.getString("Code")+"</code>";
					retour += "</directeur>";
				}
				results.close();
			}
			getDire.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(results != null)
				results.close();
			if(getDire != null)
				getDire.close();
		}
		
		retour += "</listeDirecteurs>";
		
		return Response.status(Status.OK).entity(retour).build();
	}
}
