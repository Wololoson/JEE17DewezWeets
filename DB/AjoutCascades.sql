ALTER TABLE Secretaire 
DROP CONSTRAINT FK_Secretaire_Personne;

ALTER TABLE Chirurgien 
DROP CONSTRAINT FK_Chirurgien_Personne;

ALTER TABLE Patient 
DROP CONSTRAINT FK_Patient_Personne;

----------------------------------------------------------------------------

ALTER TABLE Secretaire
ADD CONSTRAINT FK_Secretaire_Personne_Cascade
FOREIGN KEY (IdPersonne) REFERENCES Personne(IdPersonne) ON DELETE CASCADE;

ALTER TABLE Chirurgien
ADD CONSTRAINT FK_Chirurgien_Personne_Cascade
FOREIGN KEY (IdPersonne) REFERENCES Personne(IdPersonne) ON DELETE CASCADE;

ALTER TABLE Patient
ADD CONSTRAINT FK_Patient_Personne_Cascade
FOREIGN KEY (IdPersonne) REFERENCES Personne(IdPersonne) ON DELETE CASCADE;