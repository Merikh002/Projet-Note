-- Table etudiant
INSERT INTO etudiant (nom) VALUES 
('candidat3');


-- Table matiere
INSERT INTO matiere (nom) VALUES 
('PYTHON');

-- Table corecteur
INSERT INTO correcteur (nom) VALUES 
('correcteur1'), 
('correcteur2');

-- Table resolution
INSERT INTO resolution (libelle) VALUES 
('Petit'), 
('Moyen'), 
('Grand');

-- Table operation
INSERT INTO operation (signe) VALUES 
('<'), 
('<='), 
('>'), 
('>=');

-- Table parametre
INSERT INTO parametre (matiere_id, operation_id, resolution_id, seuil) VALUES
(1, 1, 1, 10.00),  -- Mathematiques, +, Correction standard
(2, 2, 2, 5.00),   -- Physique, -, Relecture approfondie
(3, 3, 3, 15.50),  -- Informatique, *, Verification automatique
(4, 4, 1, 20.00);  -- Chimie, /, Correction standard

-- Table note
INSERT INTO note (etudiant_id, correcteur_id, matiere_id, valeur) VALUES
(1, 1, 1, 12.50),
(1, 2, 2, 14.00),
(2, 1, 1, 8.50),
(2, 3, 3, 16.00),
(3, 2, 2, 11.00),
(3, 3, 4, 17.50),
(4, 1, 3, 15.00),
(5, 2, 4, 13.50);

