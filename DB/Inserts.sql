create or replace package Inserts
is
function insertChirurgien(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,specialisation Chirurgien.Specialisation%type) return number;
function insertSecretaire(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,service_secr Secretaire.Service_secr%type) return number;
function insertPatient(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,numeroChambre Patient.NumeroChambre%type,numeroPatient Patient.NumeroPatient%type) return number;
function insertNotification(priorite Notifications.priorite%type,type_notif Notifications.type_notif%type,commentaire Notifications.commentaire%type,idPersonne Notifications.idPersonne%type) return number;
procedure insertReservation(idPersonne Reservation.IdPersonne%type,idSalle Reservation.IdSalle%type,numeroPatient Reservation.NumeroPatient%type,dateRes Reservation.DateRes%type,heureRes Reservation.HeureRes%type);
function insertSalle(numero_salle Salle.numero%type,bloc_sall Salle.bloc_salle%type) return number;

id_pers number;
id_notif number;
id_salle number;

cursor cur_pers (nom_var Personne.Nom%type, prenom_var Personne.Prenom%type, date_naiss_var Personne.DateNaissance%type, num_tel_var Personne.NumeroTelephone%type, mot_de_passe_var Personne.MotDePasse%type)
is
select * from Personne
where Nom=nom_var and Prenom=prenom_var and DateNaissance=date_naiss_var and NumeroTelephone=num_tel_var and MotDePasse=mot_de_passe_var;
var_pers Personne%rowtype;

cursor cur_salle (numero_var Salle.numero%type,bloc_salle_var Salle.bloc_salle%type) is SELECT * FROM Salle where Numero=numero_var and bloc_salle=bloc_salle_var;
var_salle Salle%rowtype;
end Inserts;

cursor cur_salle (numero_var Salle.numero%type,bloc_salle_var Salle.bloc_salle%type) is SELECT * FROM Salle where Numero=numero_var and bloc_salle=bloc_salle_var;
var_salle Salle%rowtype;
end Inserts;

create or replace package body Inserts
is
function insertChirurgien(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,specialisation Chirurgien.Specialisation%type) return number
is begin
    insert into Personne (Nom, Prenom, DateNaissance, NumeroTelephone, MotDePasse) values (nom, prenom, dateNaissance, numTelephone, motDePasse) returning IdPersonne INTO id_pers;
    insert into Chirurgien (IdPersonne, Specialisation) values (id_pers, specialisation);
    return id_pers;
end insertChirurgien;

function insertSecretaire(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,service_secr Secretaire.Service_secr%type) return number
is begin
    insert into Personne (Nom, Prenom, DateNaissance, NumeroTelephone, MotDePasse) values (nom, prenom, dateNaissance, numTelephone, motDePasse) returning IdPersonne INTO id_pers;
    insert into Secretaire (IdPersonne, service_secr) values (id_pers, service_secr);
    return id_pers;
end insertSecretaire;

function insertPatient(nom Personne.nom%type,prenom Personne.prenom%type,dateNaissance Personne.DateNaissance%type,numTelephone Personne.NumeroTelephone%type,motDePasse Personne.MotDePasse%type,numeroChambre Patient.NumeroChambre%type,numeroPatient Patient.NumeroPatient%type) return number
is begin
    open cur_pers(nom_var => nom, prenom_var => prenom, date_naiss_var => dateNaissance, num_tel_var => numTelephone, mot_de_passe_var => motDePasse);
    fetch cur_pers into var_pers;
    if cur_pers%notfound then
	    insert into Personne (Nom, Prenom, DateNaissance, NumeroTelephone, MotDePasse) values (nom, prenom, dateNaissance, numTelephone, motDePasse) returning IdPersonne INTO id_pers;
	    insert into Patient (IdPersonne, numeroChambre,numeroPatient) values (id_pers, numeroChambre,numeroPatient);
	else
        id_pers := var_pers.IdPersonne;
    end if;
    return id_pers;
    close cur_pers;
end insertPatient;

function insertNotification(priorite Notifications.priorite%type,type_notif Notifications.type_notif%type,commentaire Notifications.commentaire%type,idPersonne Notifications.idPersonne%type) return number
is begin
    insert into Notifications (priorite,type_notif,commentaire,idPersonne) values (priorite,type_notif,commentaire,idPersonne) returning IdNotification INTO id_notif;
    return id_notif;
end insertNotification;

procedure insertReservation(idPersonne Reservation.IdPersonne%type,idSalle Reservation.IdSalle%type,numeroPatient Reservation.NumeroPatient%type,dateRes Reservation.DateRes%type,heureRes Reservation.HeureRes%type)
is begin
    insert into Reservation (idPersonne,idSalle,numeroPatient,dateRes,heureRes) values (idPersonne,idSalle,numeroPatient,dateRes,heureRes);
end insertReservation;

function insertSalle(numero_salle Salle.numero%type,bloc_sall Salle.bloc_salle%type) return number
is 
begin
    open cur_salle(numero_var => numero_salle,bloc_salle_var => bloc_sall);
    fetch cur_salle into var_salle;
    if cur_salle%notfound then
        insert into Salle (numero,bloc_salle) values (numero_salle,bloc_sall) returning IdSalle INTO id_salle;
    else
        id_salle := var_salle.idSalle;
    end if;
    return id_salle;
    close cur_salle;
end insertSalle;
end Inserts;