create or replace package SelectAll
is
TYPE tab_pers IS TABLE OF Personne%ROWTYPE NOT NULL INDEX BY binary_integer;
row_pers tab_pers;
TYPE tab_chir IS TABLE OF Chirurgien%ROWTYPE NOT NULL INDEX BY binary_integer;
row_chir tab_chir;
TYPE tab_secr IS TABLE OF Secretaire%ROWTYPE NOT NULL INDEX BY binary_integer;
row_secr tab_secr;
TYPE tab_dire IS TABLE OF Directeur%ROWTYPE NOT NULL INDEX BY binary_integer;
row_dire tab_dire;
TYPE tab_pati IS TABLE OF Patient%ROWTYPE NOT NULL INDEX BY binary_integer;
row_pati tab_pati;
TYPE tab_noti IS TABLE OF Notifications%ROWTYPE NOT NULL INDEX BY binary_integer;
row_noti tab_noti;
TYPE tab_res IS TABLE OF Reservation%ROWTYPE NOT NULL INDEX BY binary_integer;
row_res tab_res;

TYPE rec_chir IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,Specialisation Chirurgien.Specialisation%type);
full_chir rec_chir;
TYPE rec_secr IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,ServiceSecr Secretaire.Service_secr%type);
full_secr rec_secr;
TYPE rec_dire IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,Code Directeur.Code%type);
full_dire rec_dire;
TYPE rec_pati IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,NumeroChambre Patient.NumeroChambre%type,NumeroPatient Patient.NumeroPatient%type);
full_pati rec_pati;

TYPE tab_rec_chir IS TABLE OF rec_chir NOT NULL INDEX BY binary_integer;
row_rec_chir tab_rec_chir;
TYPE tab_rec_secr IS TABLE OF rec_secr NOT NULL INDEX BY binary_integer;
row_rec_secr tab_rec_secr;
TYPE tab_rec_dire IS TABLE OF rec_dire NOT NULL INDEX BY binary_integer;
row_rec_dire tab_rec_dire;
TYPE tab_rec_pati IS TABLE OF rec_pati NOT NULL INDEX BY binary_integer;
row_rec_pati tab_rec_pati;

function getChirurgiens return tab_rec_chir;
function getSecretaires return tab_rec_secr;
function getDirecteurs return tab_rec_dire;
function getPatients return tab_rec_pati;
function getNotifications return tab_noti;
function getReservations return tab_res;
end SelectAll;

create or replace package body SelectAll
is
function getChirurgiens return tab_rec_chir
as
begin
    select * bulk collect into row_chir from Chirurgien;

    FOR x IN 1..row_chir.count LOOP
        select * bulk collect into row_pers from Personne where IdPersonne = row_chir(x).IdPersonne;
        row_rec_chir(x).IdPersonne := row_pers(1).IdPersonne;
        row_rec_chir(x).Nom := row_pers(1).Nom;
        row_rec_chir(x).Prenom := row_pers(1).Prenom;
        row_rec_chir(x).DateNaissance := row_pers(1).DateNaissance;
        row_rec_chir(x).NumeroTelephone := row_pers(1).NumeroTelephone;
        row_rec_chir(x).MotDePasse := row_pers(1).MotDePasse;
        row_rec_chir(x).Specialisation := row_chir(x).Specialisation;
    END LOOP;

    RETURN row_rec_chir;
end getChirurgiens;

function getSecretaires return tab_rec_secr
as
begin
    select * bulk collect into row_secr from Secretaire;

    FOR x IN 1..row_secr.count LOOP
        select * bulk collect into row_pers from Personne where IdPersonne = row_secr(x).IdPersonne;
        row_rec_secr(x).IdPersonne := row_pers(1).IdPersonne;
        row_rec_secr(x).Nom := row_pers(1).Nom;
        row_rec_secr(x).Prenom := row_pers(1).Prenom;
        row_rec_secr(x).DateNaissance := row_pers(1).DateNaissance;
        row_rec_secr(x).NumeroTelephone := row_pers(1).NumeroTelephone;
        row_rec_secr(x).MotDePasse := row_pers(1).MotDePasse;
        row_rec_secr(x).ServiceSecr := row_secr(x).Service_secr;
    END LOOP;

    RETURN row_rec_secr;
end getSecretaires;

function getDirecteurs return tab_rec_dire
as
begin
    select * bulk collect into row_dire from Directeur;

    FOR x IN 1..row_dire.count LOOP
        select * bulk collect into row_pers from Personne where IdPersonne = row_dire(x).IdPersonne;
        row_rec_dire(x).IdPersonne := row_pers(1).IdPersonne;
        row_rec_dire(x).Nom := row_pers(1).Nom;
        row_rec_dire(x).Prenom := row_pers(1).Prenom;
        row_rec_dire(x).DateNaissance := row_pers(1).DateNaissance;
        row_rec_dire(x).NumeroTelephone := row_pers(1).NumeroTelephone;
        row_rec_dire(x).MotDePasse := row_pers(1).MotDePasse;
        row_rec_dire(x).Code := row_dire(x).Code;
    END LOOP;

    RETURN row_rec_dire;
end getDirecteurs;

function getPatients return tab_rec_pati
as
begin
    select * bulk collect into row_pati from Patient;

    FOR x IN 1..row_pati.count LOOP
        select * bulk collect into row_pers from Personne where IdPersonne = row_pati(x).IdPersonne;
        row_rec_pati(x).IdPersonne := row_pers(1).IdPersonne;
        row_rec_pati(x).Nom := row_pers(1).Nom;
        row_rec_pati(x).Prenom := row_pers(1).Prenom;
        row_rec_pati(x).DateNaissance := row_pers(1).DateNaissance;
        row_rec_pati(x).NumeroTelephone := row_pers(1).NumeroTelephone;
        row_rec_pati(x).MotDePasse := row_pers(1).MotDePasse;
        row_rec_pati(x).NumeroChambre := row_pati(x).NumeroChambre;
        row_rec_pati(x).NumeroPatient := row_pati(x).NumeroPatient;
    END LOOP;

    RETURN row_rec_pati;
end getPatients;

function getNotifications return tab_noti
as
begin
    select * bulk collect into row_noti from Notifications;
    RETURN row_noti;
end getNotifications;

function getReservations return tab_res
as
begin
    select * bulk collect into row_res from Reservation;
    RETURN row_res;
end getNotifications;

end SelectAll;