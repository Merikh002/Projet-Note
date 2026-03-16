CREATE TABLE  etudiant (
    id int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(255) NOT NULL,
);

CREATE  TABLE matiere(
    id int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(255) NOT NULL
);

CREATE TABLE corecteur(
    id int PRIMARY KEY AUTO_INCREMENT,
    nom varchar(255) NOT NULL
);

CREATE TABLE resolution(
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(255) NOT NULL
);

CREATE TABLE operation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    signe VARCHAR(255) NOT NULL
);

CREATE TABLE parametre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matiere_id INT,
    operation_id INT,
    resolution_id INT,
    seuil DECIMAL(10,2),
    FOREIGN KEY (matiere_id) REFERENCES matiere(id),
    FOREIGN KEY (resolution_id) REFERENCES resolution(id),
    FOREIGN KEY (operation_id) REFERENCES operation(id)
);

CREATE TABLE note (
    id INT PRIMARY KEY AUTO_INCREMENT,
    etudiant_id INT,
    correcteur_id INT,
    matiere_id INT,
    valeur DECIMAL(10,2),
    FOREIGN KEY (etudiant_id) REFERENCES etudiant(id),
    FOREIGN KEY (correcteur_id) REFERENCES corecteur(id),
    FOREIGN KEY (matiere_id) REFERENCES matiere(id)
);

CREATE TABLE note_finale (
    id INT PRIMARY KEY AUTO_INCREMENT,
    etudiant_id INT,
    matiere_id INT,
    valeur DECIMAL(10,2),
    FOREIGN KEY (etudiant_id) REFERENCES etudiant(id),
    FOREIGN KEY (matiere_id) REFERENCES matiere(id)
);