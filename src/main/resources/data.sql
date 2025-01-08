CREATE DATABASE IF NOT EXISTS projet;
USE projet;


-- Apartments & Availability

CREATE TABLE IF NOT EXISTS apartment(
    id VARCHAR(36) PRIMARY KEY,
    nb_piece INT NOT NULL,
    price INT NOT NULL,
    area INT NOT NULL,
    nb_people INT NOT NULL,
    adress VARCHAR(255),
    owner_id INT,
    availability_id INT,
    INDEX idx_owner_id (owner_id),
    INDEX idx_availability_id (availability_id)
);


CREATE TABLE IF NOT EXISTS owner(
    id INT AUTO_INCREMENT PRIMARY KEY,
    lastname VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    contact VARCHAR(255),
    adress VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS apartmentavailability(
    id INT AUTO_INCREMENT PRIMARY KEY,
    availability ENUM('free','occupied','underConstruction'),
    week INT NOT NULL,
    year INT NOT NULL
);

INSERT INTO apartment (id, nb_piece, price, area, nb_people, adress, owner_id, availability_id) VALUES
('e6c8d15a-3cda-4ef3-99d4-bbb7e0e1e23f', 3, 1200, 75, 4, '123 Main Street', 1, 2),
('88a10707-3d37-4f2b-b57b-5d93db7d3073', 2, 900, 50, 2, '456 Elm Street', 2, 3),
('5f0be6be-56a1-4d96-8bbd-05354a9d84c2', 4, 1500, 90, 5, '789 Oak Avenue', 3, 1),
('dcd079ea-9a3e-41f5-9a8d-1200c24a0149', 1, 600, 30, 1, '321 Pine Road', 4, 4),
('0777b23b-2e2a-44fc-a953-dac8d06f400a', 5, 2000, 120, 6, '654 Maple Boulevard', 5, 5);

INSERT INTO owner (lastname, surname, contact, adress) VALUES
('Smith', 'John', 'smith@example.com', '123 Main Street'),
('Johnson', 'Emily', 'johnson@example.com', '456 Elm Street'),
('Williams', 'Michael', 'williams@example.com', '789 Oak Avenue'),
('Brown', 'Sarah', 'brown@example.com', '321 Pine Road'),
('Jones', 'Robert', 'jones@example.com', '654 Maple Boulevard');

INSERT INTO apartmentavailability (availability, week, year) VALUES
('free', 3, 2024),
('occupied', 19, 2024),
('underConstruction', 5, 2024),
('free', 12, 2024),
('occupied', 46, 2024);