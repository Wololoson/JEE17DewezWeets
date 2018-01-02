create or replace package SelectOne
is
TYPE select_one_cursor IS REF CURSOR;

function getChirurgien(idChir Chirurgien.IdPersonne%type) return select_one_cursor;
function getSecretaire(idSecr Secretaire.IdPersonne%type) return select_one_cursor;
function getPatient(idPati Patient.IdPersonne%type) return select_one_cursor;
function getSalle(idSall Salle.IdSalle%type) return select_one_cursor;
end SelectOne;

create or replace package body SelectOne
is
function getChirurgien(idChir Chirurgien.IdPersonne%type) return select_one_cursor
as
    chir_cur select_one_cursor;
begin
    OPEN chir_cur FOR select *  from Chirurgien A inner join Personne B on A.IdPersonne = B.IdPersonne
                      where A.IdPersonne = idChir;

    RETURN chir_cur;
end getChirurgien;

function getSecretaire(idSecr Secretaire.IdPersonne%type) return select_one_cursor
as
    secr_cur select_one_cursor;
begin
    OPEN secr_cur FOR select * from Secretaire A inner join Personne B on A.IdPersonne = B.IdPersonne 
                      where A.IdPersonne = idSecr;

    RETURN secr_cur;
end getSecretaire;

function getPatient(idPati Patient.IdPersonne%type) return select_one_cursor
as
    pati_cur select_one_cursor;
begin
    OPEN pati_cur FOR select * from Patient A inner join Personne B on A.IdPersonne = B.IdPersonne
                       where A.NumeroPatient = idPati;
    
    RETURN pati_cur;
end getPatient;

function getSalle(idSall Salle.IdSalle%type) return select_one_cursor
as
    salle_cur select_one_cursor;
begin
    OPEN salle_cur FOR select * from Salle where IdSalle = idSall;

    RETURN salle_cur;
end getSalle;
end SelectOne;