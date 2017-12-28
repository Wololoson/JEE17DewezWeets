create or replace package Updates
is
procedure updateChirurgien(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,specialisation Chirurgien.Specialisation%type);
procedure updateSecretaire(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,service_secr Secretaire.Service_secr%type);
procedure updatePatient(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,numeroChambre Patient.NumeroChambre%type,numeroPatient Patient.NumeroPatient%type);
procedure updateReservation(idPersonne Reservation.IdPersonne%type,idSalle Reservation.IdSalle%type,numeroPatient Reservation.NumeroPatient%type,dateHeure Reservation.DateHeure%type);
procedure updateSalle(numero Salle.numero%type,bloc_salle Salle.bloc_salle%type);

id_pers number;
end Updates;

create or replace package body Updates
is
procedure updateChirurgien(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,specialisation Chirurgien.Specialisation%type)
is begin
	update Personne set Nom = nom, Prenom = prenom, DateNaissance = dateNaissance, NumeroTelephone = numTelephone, MotDePasse = motDePasse returning IdPersonne INTO id_pers;
    update Chirurgien set IdPersonne = id_pers, specialisation = specialisation;
end updateChirurgien;

procedure updateSecretaire(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,service_secr Secretaire.Service_secr%type)
is begin
	update Personne set Nom = nom, Prenom = prenom, DateNaissance = dateNaissance, NumeroTelephone = numTelephone, MotDePasse = motDePasse returning IdPersonne INTO id_pers;
    update Secretaire set IdPersonne = id_pers, service_secr = service_secr;
end updateSecretaire;

procedure updatePatient(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,numeroChambre Patient.NumeroChambre%type,numeroPatient Patient.NumeroPatient%type)
is begin
	update Personne set Nom = nom, Prenom = prenom, DateNaissance = dateNaissance, NumeroTelephone = numTelephone, MotDePasse = motDePasse returning IdPersonne INTO id_pers;
    update Patient set IdPersonne = id_pers, numeroChambre = numeroChambre,numeroPatient = numeroPatient;
end updatePatient;

procedure updateReservation(idPersonne Reservation.IdPersonne%type,idSalle Reservation.IdSalle%type,numeroPatient Reservation.NumeroPatient%type,dateHeure Reservation.DateHeure%type)
is begin
    update Reservation set idPersonne = idPersonne,idSalle = idSalle,numeroPatient = numeroPatient,dateHeure = dateHeure;
end updateReservation;

procedure updateSalle(numero Salle.numero%type,bloc_salle Salle.bloc_salle%type)
is begin
    update Salle set numero = numero,bloc_salle = bloc_salle;
end updateSalle;
end Updates;