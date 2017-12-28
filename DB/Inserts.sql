create or replace package Inserts
is
procedure insertChirurgien(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,specialisation Chirurgien.Specialisation%type);
procedure insertSecretaire(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,service_secr Secretaire.Service_secr%type);
procedure insertPatient(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,numeroChambre Patient.NumeroChambre%type,numeroPatient Patient.NumeroPatient%type);
procedure insertNotification(priorite Notifications.priorite%type,type_notif Notifications.type_notif%type,commentaire Notifications.commentaire%type,idPersonne Notifications.idPersonne%type);
procedure insertReservation(idPersonne Reservation.IdPersonne%type,idSalle Reservation.IdSalle%type,numeroPatient Reservation.NumeroPatient%type,dateHeure Reservation.DateHeure%type);
procedure insertSalle(numero Salle.numero%type,bloc_salle Salle.bloc_salle%type);

id_pers number;
end Inserts;

create or replace package body Inserts
is
procedure insertChirurgien(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,specialisation Chirurgien.Specialisation%type)
is begin
	insert into Personne (Nom, Prenom, DateNaissance, NumeroTelephone, MotDePasse) values (nom, prenom, dateNaissance, numTelephone, motDePasse) returning IdPersonne INTO id_pers;
    insert into Chirurgien (IdPersonne, Specialisation) values (id_pers, specialisation);
end insertChirurgien;

procedure insertSecretaire(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,service_secr Secretaire.Service_secr%type)
is begin
	insert into Personne (Nom, Prenom, DateNaissance, NumeroTelephone, MotDePasse) values (nom, prenom, dateNaissance, numTelephone, motDePasse) returning IdPersonne INTO id_pers;
    insert into Secretaire (IdPersonne, service_secr) values (id_pers, service_secr);
end insertSecretaire;

procedure insertPatient(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,numeroChambre Patient.NumeroChambre%type,numeroPatient Patient.NumeroPatient%type)
is begin
	insert into Personne (Nom, Prenom, DateNaissance, NumeroTelephone, MotDePasse) values (nom, prenom, dateNaissance, numTelephone, motDePasse) returning IdPersonne INTO id_pers;
    insert into Patient (IdPersonne, numeroChambre,numeroPatient) values (id_pers, numeroChambre,numeroPatient);
end insertPatient;

procedure insertNotification(priorite Notifications.priorite%type,type_notif Notifications.type_notif%type,commentaire Notifications.commentaire%type,idPersonne Notifications.idPersonne%type)
is begin
	insert into Notifications (priorite,type_notif,commentaire,idPersonne) values (priorite,type_notif,commentaire,idPersonne);
end insertNotification;

procedure insertReservation(idPersonne Reservation.IdPersonne%type,idSalle Reservation.IdSalle%type,numeroPatient Reservation.NumeroPatient%type,dateHeure Reservation.DateHeure%type)
is begin
    insert into Reservation (idPersonne,idSalle,numeroPatient,dateHeure) values (idPersonne,idSalle,numeroPatient,dateHeure);
end insertReservation;

procedure insertSalle(numero Salle.numero%type,bloc_salle Salle.bloc_salle%type)
is begin
    insert into Salle (numero,bloc_salle) values (numero,bloc_salle);
end insertSalle;
end Inserts;