drop table Personne;
drop table Secretaire;
drop table Patient;
drop table Directeur;
drop table Chirurgien;
drop table Notifications;
drop table Salle;
drop table Reservation;

create table Personne (
                       IdPersonne       number not null,
                       Nom              varchar2(50),
                       Prenom           varchar2(50),
                       DateNaissance    date,
                       NumeroTelephone  varchar2(20),
                       MotDePasse       varchar2(30),
                       constraint PK_Personne primary key (IdPersonne)
                       );

create table Secretaire (
                         IdPersonne     number not null,
                         Service_Secr   varchar2(30),
                         constraint PK_Secretaire primary key (IdPersonne),
                         constraint FK_Secretaire_Personne foreign key (IdPersonne)
                         references Personne (IdPersonne)
                         );
                         
create table Chirurgien (
                         IdPersonne      number not null,
                         Specialisation  varchar2(30),
                         constraint PK_Chirurgien primary key (IdPersonne),
                         constraint FK_Chirurgien_Personne foreign key (IdPersonne)
                         references Personne (IdPersonne)
                         );
                         
create table Directeur (
                         IdPersonne     number not null,
                         Code           varchar2(4),
                         constraint PK_Directeur primary key (IdPersonne),
                         constraint FK_Directeur_Personne foreign key (IdPersonne)
                         references Personne (IdPersonne)
                         );
                         
create table Patient (
                         IdPersonne     number not null,
                         NumeroChambre  varchar2(3),
                         NumeroPatient  varchar2(5) not null,
                         constraint PK_Patient primary key (NumeroPatient),
                         constraint FK_Patient_Personne foreign key (IdPersonne)
                         references Personne (IdPersonne)
                         );
                         
create table Notifications (
                        IdNotification  number not null,
                        Priorite        integer,
                        Type_Notif      integer,
                        Commentaire     varchar2(300),
                        IdPersonne      number not null,
                        constraint PK_Notification primary key (IdNotification),
                        constraint FK_Notification_Chirurgien foreign key (IdPersonne)
                        references Chirurgien (IdPersonne)
                        );
                        
create table Salle (
                        IdSalle         number not null,
                        Numero          varchar2(2),
                        Bloc_Salle      char,
                        constraint PK_Salle primary key (IdSalle)
                        );
                        
create table Reservation (
                        IdPersonne      number not null,
                        IdSalle         number not null,
                        NumeroPatient   varchar2(5) not null,
                        DateHeure       date,
                        constraint PK_Reservation primary key (IdPersonne,IdSalle,NumeroPatient),
                        constraint FK_Reservation_Chirurgien foreign key (IdPersonne)
                        references Chirurgien (IdPersonne),
                        constraint FK_Reservation_Salle foreign key (IdSalle)
                        references Salle (IdSalle),
                        constraint FK_Reservation_Patient foreign key (NumeroPatient)
                        references Patient (NumeroPatient)
                        );