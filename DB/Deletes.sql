create or replace package Deletes
is
procedure deleteChirurgien(idChir Chirurgien.IdPersonne%type);
procedure deleteSecretaire(idSecr Secretaire.IdPersonne%type);
procedure deletePatient(idPati Patient.IdPersonne%type);
procedure deleteNotification(idNoti Notifications.IdNotification%type);
procedure deleteReservation(idPers Reservation.IdPersonne%type,idSall Reservation.IdSalle%type,numPati Reservation.NumeroPatient%type,dateHeur Reservation.DateHeure%type);
procedure deleteSalle(idSall Salle.IdSalle%type);
end Deletes;

create or replace package body Deletes
is
procedure deleteChirurgien(idChir Chirurgien.IdPersonne%type)
is begin
    delete from Chirurgien where IdPersonne = idChir;
end deleteChirurgien;

procedure deleteSecretaire(idSecr Secretaire.IdPersonne%type)
is begin
    delete from Secretaire where IdPersonne = idSecr;
end deleteSecretaire;

procedure deletePatient(idPati Patient.IdPersonne%type)
is begin
    delete from Patient where IdPersonne = idPati;
end deletePatient;

procedure deleteNotification(idNoti Notifications.IdNotification%type)
is begin
	delete from Notifications where IdNotification = idNoti;
end deleteNotification;

procedure deleteReservation(idPers Reservation.IdPersonne%type,idSall Reservation.IdSalle%type,numPati Reservation.NumeroPatient%type)
is begin
    delete from Reservation where IdPersonne = idPers and IdSalle = idSall and numeroPatient = numPati;
end deleteReservation;

procedure deleteSalle(idSall Salle.IdSalle%type)
is begin
    delete from Salle where IdSalle = idSall;
end deleteSalle;
end Deletes;