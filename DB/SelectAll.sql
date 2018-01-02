create or replace package SelectAll
is
TYPE select_all_cursor IS REF CURSOR;

function getChirurgiens return select_all_cursor;
function getSecretaires return select_all_cursor;
function getDirecteurs return select_all_cursor;
function getPatients return select_all_cursor;
function getNotifications return select_all_cursor;
function getReservations return select_all_cursor;
end SelectAll;

create or replace package body SelectAll
is
function getChirurgiens return select_all_cursor
as
    chir_cur select_all_cursor;
begin
    OPEN chir_cur FOR select *  from Chirurgien A inner join Personne B on A.IdPersonne = B.IdPersonne;

    RETURN chir_cur;
end getChirurgiens;

function getSecretaires return select_all_cursor
as
    secr_cur select_all_cursor;
begin
    OPEN secr_cur FOR select * from Secretaire A inner join Personne B on A.IdPersonne = B.IdPersonne;

    RETURN secr_cur;
end getSecretaires;

function getDirecteurs return select_all_cursor
as
    dire_cur select_all_cursor;
begin
    OPEN dire_cur FOR select * from Directeur A inner join Personne B on A.IdPersonne = B.IdPersonne;

    RETURN dire_cur;
end getDirecteurs;

function getPatients return select_all_cursor
as
    pati_cur select_all_cursor;
begin
    OPEN pati_cur FOR select * from Patient A inner join Personne B on A.IdPersonne = B.IdPersonne;

    RETURN pati_cur;
end getPatients;

function getNotifications return select_all_cursor
as
    noti_cur select_all_cursor;
begin
    OPEN noti_cur FOR select * from Notifications;

    RETURN noti_cur;
end getNotifications;

function getReservations return select_all_cursor
as
    res_cur select_all_cursor;
begin
    OPEN res_cur FOR select * from Reservation;

    RETURN res_cur;
end getReservations;

end SelectAll;