TYPE tab_pers IS TABLE OF Personne%ROWTYPE NOT NULL INDEX BY binary_integer;
row_pers tab_pers;

------------------------------

SELECT * INTO row_pers FROM Personne;
DBMS_OUTPUT.PUT_LINE(row_pers);
RETURN row_pers;