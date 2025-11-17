-- ===============================
-- 1) Datenbank erstellen
-- ===============================
CREATE DATABASE IF NOT EXISTS lost_and_found;
USE lost_and_found;

-- ===============================
-- 2) Tabellen erstellen
-- ===============================

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL
);

CREATE TABLE item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    DESCRIPTION TEXT,
    TYPE VARCHAR(10) NOT NULL, -- 'lost' oder 'found'
    location VARCHAR(150),
    DATE DATE,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE contact_request (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message TEXT,
    user_id INT NOT NULL,
    item_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);

-- ===============================
-- 3) Beispiel-Daten
-- ===============================

INSERT INTO users (NAME, email) VALUES
('Noah Burren', 'noah@example.com'),
('Levi Fuchs', 'levi@example.com'),
('Random Dude', 'random@example.com');

INSERT INTO category (NAME) VALUES
('Elektronik'),
('Kleidung'),
('Dokumente'),
('Sonstiges');

INSERT INTO item (title, DESCRIPTION, TYPE, location, DATE, category_id) VALUES
('iPhone 14 Pro', 'Schwarzes iPhone ohne Hülle', 'lost', 'Zürich HB', '2025-11-10', 1),
('Portemonnaie', 'Braunes Leder, enthält ID', 'lost', 'Oerlikon', '2025-11-11', 3),
('Jacke', 'Schwarze Winterjacke', 'found', 'Glattzentrum', '2025-11-09', 2),
('Kopfhörer', 'Weiße AirPods', 'found', 'Bellevue', '2025-11-08', 1);

INSERT INTO contact_request (message, user_id, item_id) VALUES
('Gehört mir!', 1, 3),
('Ich glaube, das ist mein iPhone', 2, 1),
('Ist das noch verfügbar?', 3, 4);
