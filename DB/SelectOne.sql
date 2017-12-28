create or replace package SelectOne
is
TYPE tab_pers IS TABLE OF Personne%ROWTYPE INDEX BY binary_integer;
row_pers tab_pers;
TYPE tab_chir IS TABLE OF Chirurgien%ROWTYPE INDEX BY binary_integer;
row_chir tab_chir;
TYPE tab_secr IS TABLE OF Secretaire%ROWTYPE INDEX BY binary_integer;
row_secr tab_secr;
TYPE tab_pati IS TABLE OF Patient%ROWTYPE INDEX BY binary_integer;
row_pati tab_pati;
TYPE tab_sall IS TABLE OF Salle%ROWTYPE INDEX BY binary_integer;
row_sall tab_sall;

TYPE rec_chir IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,Specialisation Chirurgien.Specialisation%type);
full_chir rec_chir;
TYPE rec_secr IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,ServiceSecr Secretaire.Service_secr%type);
full_secr rec_secr;
TYPE rec_pati IS RECORD (IdPersonne Personne.IdPersonne%TYPE,Nom Personne.nom%type,Prenom Personne.prenom%type,DateNaissance Personne.DateNaissance%type,NumeroTelephone Personne.NumeroTelephone%type,MotDePasse Personne.MotDePasse%type,NumeroChambre Patient.NumeroChambre%type,NumeroPatient Patient.NumeroPatient%type);
full_pati rec_pati;

function getChirurgien(idChir Chirurgien.IdPersonne%type) return rec_chir;
function getSecretaire(idSecr Secretaire.IdPersonne%type) return rec_secr;
function getPatient(idPati Patient.IdPersonne%type) return rec_pati;
function getSalle(idSall Salle.IdSalle%type) return tab_sall;
end SelectOne;

create or replace package body SelectOne
is
function getChirurgien(idChir Chirurgien.IdPersonne%type) return rec_chir
as
begin
    select * bulk collect into row_pers from Personne where IdPersonne = idChir;
    select * bulk collect into row_chir from Chirurgien where IdPersonne = idChir;

    full_chir.IdPersonne := row_pers(0).IdPersonne;
    full_chir.Nom := row_pers(0).Nom;
    full_chir.Prenom := row_pers(0).Prenom;
    full_chir.DateNaissance := row_pers(0).DateNaissance;
    full_chir.NumeroTelephone := row_pers(0).NumeroTelephone;
    full_chir.MotDePasse := row_pers(0).MotDePasse;
    full_chir.Specialisation := row_chir(0).Specialisation;

    RETURN full_chir;
end getChirurgien;

function getSecretaire(idSecr Secretaire.IdPersonne%type) return rec_secr
as
begin
    select * bulk collect into row_pers from Personne where IdPersonne = idSecr;
    select * bulk collect into row_secr from Secretaire where IdPersonne = idSecr;

    full_secr.IdPersonne := row_pers(0).IdPersonne;
    full_secr.Nom := row_pers(0).Nom;
    full_secr.Prenom := row_pers(0).Prenom;
    full_secr.DateNaissance := row_pers(0).DateNaissance;
    full_secr.NumeroTelephone := row_pers(0).NumeroTelephone;
    full_secr.MotDePasse := row_pers(0).MotDePasse;
    full_secr.ServiceSecr := row_secr(0).Service_secr;

    RETURN full_secr;
end getSecretaire;

function getPatient(numPati Patient.NumeroPatient%TYPE) return rec_pati
as
begin
    select * bulk collect into row_pati from Patient where NumeroPatient = numPati;
    select * bulk collect into row_pers from Personne where IdPersonne = row_pati(0).IdPersonne;

    full_pati.IdPersonne := row_pers(0).IdPersonne;
    full_pati.Nom := row_pers(0).Nom;
    full_pati.Prenom := row_pers(0).Prenom;
    full_pati.DateNaissance := row_pers(0).DateNaissance;
    full_pati.NumeroTelephone := row_pers(0).NumeroTelephone;
    full_pati.MotDePasse := row_pers(0).MotDePasse;
    full_pati.NumeroChambre := row_pati(0).NumeroChambre;
    full_pati.NumeroPatient := row_pati(0).NumeroPatient;
    
    RETURN full_pati;
end getPatient;

function getSalle(idSall Salle.IdSalle%type) return tab_sall
as
begin
    select * bulk collect into row_sall from Salle where IdSalle = idSall;
    RETURN row_sall;
end getSalle;
end SelectOne;