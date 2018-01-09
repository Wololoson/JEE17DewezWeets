<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="be.gestionhopital.Models.Personne" %>
<%@ page import="be.gestionhopital.Models.Chirurgien" %>
<%@ page import="be.gestionhopital.Models.Secretaire" %>
<%@ page import="be.gestionhopital.Models.ListPersonnel" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Personnel</title>
		<link type="text/css" rel="stylesheet" href="../JEEGestionHopital/Views/css/personnel.css"/>
		<script>
			window.onload = function(){
				var modal = document.getElementById("modal");
				var addBtn = document.getElementById("modalDisplay");
				var addClose = document.getElementsByClassName("close")[0];
			
				addBtn.onclick = function() {
				    modal.style.display = "block";
				}
				
				addClose.onclick = function() {
				    modal.style.display = "none";
				}
				
				window.onclick = function(event) {
				    if (event.target == modal) {
				        modal.style.display = "none";
				    }
				}
			}
			function supplDisplay(i){
				var spec = document.getElementById("spec_tr");
				var serv = document.getElementById("serv_tr");
				var spec_input = document.getElementById("spec");
				var serv_input = document.getElementById("serv");
				
				if(i == 0){
					spec.style.display = "table-row";
					spec_input.required = true;
					serv.style.display = "none";
					serv_input.required = false;
				}
				else{
					spec.style.display = "none";
					spec_input.required = false;
					serv.style.display = "table-row";
					serv_input.required = true;
				}
			}
		</script>
	</head>
	<body>
	<h1>Gestion du personnel</h1>
	<%
		HttpSession sess = request.getSession();
		String type = (String) sess.getAttribute("type");
		Personne p = (Personne) sess.getAttribute(type);
		ListPersonnel lp = (ListPersonnel) request.getAttribute("lp");
		ArrayList<String> erreurs = (ArrayList<String>) request.getAttribute("erreurs");
		int i = 0;
		int j = 0;
	%>
	
	<div id="modal" class="modal">
		<div class="modal-content">
	    	<span class="close">&times;</span>
			<form action="ServletPersonnel" method="post">
				<table cellspacing="0" cellpadding="5">
						<tr>
							<th colspan="2">
								Type
							</th>
						</tr>
						<tr>
							<td colspan="2">
								<select id="listPers" name="listPers">
									<option value="chirurgien" onclick="supplDisplay(0)">Chirurgien</option>
									<option value="secretaire" onclick="supplDisplay(1)">Secrétaire</option>
								</select>
							</td>
						</tr>
					<tr>
						<th colspan="2">
							Informations
						</th>
					</tr>
					<tr>
						<td>
							Nom :
						</td>
						<td>
							<input type="text" name="nom" id="nom" value="" size="20" required="required" maxlength="50" />
						</td>
					</tr>
					<tr>
						<td>
							Prénom :
						</td>
						<td>
							<input type="text" name="prenom" id="prenom" value="" size="20" required="required" maxlength="50" />
						</td>
					</tr>
					<tr>
						<td>
							Date de naissance :
						</td>
						<td>
							<input type="text" name="dateNaissJ" id="dateNaissJ" value="" size="3" required="required" maxlength="2" placeholder="01" />
							<input type="text" name="dateNaissM" id="dateNaissM" value="" size="3" required="required" maxlength="2" placeholder="01" />
							<input type="text" name="dateNaissA" id="dateNaissA" value="" size="3" required="required" maxlength="4" placeholder="2000" />
						</td>
					</tr>
					<tr>
						<td>
							Numéro de téléphone :
						</td>
						<td>
							<input type="text" name="numTel" id="numTel" value="" size="20" required="required" maxlength="20" placeholder="0123/45.67.89" />
						</td>
					</tr>
					<tr id="spec_tr">
						<td>
							Spécialisation :
						</td>
						<td>
							<input type="text" name="spec" id="spec" value="" size="20" required="required" maxlength="30" placeholder="" />
						</td>
					</tr>
					<tr id="serv_tr" style="display:none;">
						<td>
							Service :
						</td>
						<td>
							<input type="text" name="serv" id="serv" value="" size="20" maxlength="30" placeholder="" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" name="ajout" id="ajout" value="Valider"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<form action="ServletPersonnel" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th colspan="6">
					Chirurgien
				</th>
			</tr>
			<tr>
				<th>
					Nom
				</th>
				<th>
					Prénom
				</th>
				<th>
					Date de naissance
				</th>
				<th>
					Numéro de téléphone
				</th>
				<th>
					Spécialisation
				</th>
				<td>
				</td>
			</tr>
				<%
				for(Chirurgien c : lp.getListChirurgien()){
						sess.setAttribute("chir"+Integer.toString(i), c);%>
					<tr>
						<td>
							<%=c.getNom() %>
						</td>
						<td>
							<%=c.getPrenom() %>
						</td>
						<td>
							<%=c.getDateNaiss() %>
						</td>
						<td>
							<%=c.getNumTelephone() %>
						</td>
						<td>
							<%=c.getSpecialisation() %>
						</td>
						<td>
							<input type="radio" id="chir" name="chir" value="<%=i %>"/>
						</td>
					</tr>
					<%
					i++;
				}%>
				<tr>
				<th colspan="6">
					Secretaire
				</th>
				</tr>
				<tr>
					<th>
						Nom
					</th>
					<th>
						Prénom
					</th>
					<th>
						Date de naissance
					</th>
					<th>
						Numéro de téléphone
					</th>
					<th>
						Service
					</th>
					<td>
					</td>
				</tr>
				<%
				for(Secretaire s : lp.getListSecretaire()){
						sess.setAttribute("secr"+Integer.toString(i), s);%>
						<tr>
							<td>
								<%=s.getNom() %>
							</td>
							<td>
								<%=s.getPrenom() %>
							</td>
							<td>
								<%=s.getDateNaiss() %>
							</td>
							<td>
								<%=s.getNumTelephone() %>
							</td>
							<td>
								<%=s.getService() %>
							</td>
							<td>
								<input type="radio" id="secr" name="secr" value="<%=i %>"/>
							</td>
						</tr>
					<%
					i++;
				}%>
			</table>
			<input type="button" name="modalDisplay" id="modalDisplay" value="Ajouter"/>
			<input type="submit" name="suppr" id="suppr" value="Supprimer"/>
			<input type="submit" name="retour" id="retour" value="Retour"/>
		</form>
		<ul style="color:RED">
		<%
			if(erreurs != null){
				for (String s : erreurs) {
		%>
				<li>
					<%=s %>
				</li>
		<%	
				}
			}
		%>
		</ul>
	</body>
</html>