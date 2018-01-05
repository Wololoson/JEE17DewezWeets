<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="be.gestionhopital.Models.Patient" %>
<%@ page import="be.gestionhopital.Models.ListPatient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Patients</title>
	</head>
	<body>
	<h1>Gestion de la liste des patients</h1>
	<%
		ListPatient lp = (ListPatient) request.getAttribute("lp");
		boolean isModif = (Boolean) request.getAttribute("isModif");
		int selected = (Integer) request.getAttribute("i");
		int i = 0;
	%>
	
	<form action="ServletPatient" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>
					Num�ro du patient
				</th>
				<th>
					Nom
				</th>
				<th>
					Pr�nom
				</th>
				<th>
					Date de naissance
				</th>
				<th>
					Num�ro de t�l�phone
				</th>
				<th>
					Num�ro de chambre
				</th>
				<td>
				</td>
			</tr>
			<%
				for(Patient p : lp.getListPatient()){
					if(isModif && i == selected){%>
						<tr>
							<td>
						        <input type="text" id="numPatientModif" name="numPatientModif" value="<%=p.getNumPatient() %>" required size="20" maxlength="5" />
						    </td>
						    <td>
						        <input type="text" id="nomPatientModif" name="nomPatientModif" value="<%=p.getNom() %>" required size="20" maxlength="50" />
						    </td>
						    <td>
						        <input type="text" id="prenomPatientModif" name="prenomPatientModif" value="<%=p.getPrenom() %>" required size="20" maxlength="50" />
						    </td>
						    <td>
						    	<%
						    		String date = p.getDateNaiss().toString();
							    	int premierTiret = date.indexOf("-");
									int deuxiemeTiret = date.indexOf('-', premierTiret+1);
									String annee = date.substring(0,premierTiret);
									String mois = date.substring(premierTiret+1,deuxiemeTiret);
									String jour = date.substring(deuxiemeTiret+1);
						    	%>
						        <input type="text" id="dateNaissJModif" name="dateNaissJModif" value="<%=jour %>" required size="3" maxlength="2" />
						        /
						        <input type="text" id="dateNaissMModif" name="dateNaissMModif" value="<%=mois %>" required size="3" maxlength="2" />
						        /
						        <input type="text" id="dateNaissAModif" name="dateNaissAModif" value="<%=annee %>" required size="3" maxlength="4" />
						    </td>
						    <td>
						        <input type="text" id="numTelPatientModif" name="numTelPatientModif" value="<%=p.getNumTelephone() %>" required size="20" maxlength="20" />
						    </td>
						    <td>
						        <input type="text" id="numChPatientModif" name="numChPatientModif" value="<%=p.getNumChambre() %>" required size="20" maxlength="3" />
						    </td>
						    <td>
						    	<input type="hidden" name="selected" id="selected" value="<%=selected %>"/>
						        <input type="submit" name="validModif" id="validModif" value="Valider"/>
						    </td>
						</tr>
					<%}else{ %>
						<tr>
							<td>
								<%=p.getNumPatient() %>
							</td>
							<td>
								<%=p.getNom() %>
							</td>
							<td>
								<%=p.getPrenom() %>
							</td>
							<td>
								<%=p.getDateNaiss() %>
							</td>
							<td>
								<%=p.getNumTelephone() %>
							</td>
							<td>
								<%=p.getNumChambre() %>
							</td>
							<td>
								<input type="radio" id="pat" name="pat" value="<%=i %>"/>
							</td>
						</tr>
					<%}
					i++;
				}%>
			</table>
			<input type="submit" name="modif" id="modif" value="Modifier"/>
			<input type="submit" name="suppr" id="suppr" value="Supprimer"/>
			<input type="submit" name="retour" id="retour" value="Retour"/>
		</form>
	</body>
</html>