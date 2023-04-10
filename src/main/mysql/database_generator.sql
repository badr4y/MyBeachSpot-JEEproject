CREATE DATABASE mybeachspot;

USE mybeachspot;

CREATE TABLE users (
                       username VARCHAR(255) NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       PRIMARY KEY (username)
);

CREATE TABLE feedback (
                          Beach_Name VARCHAR(255) NOT NULL,
                          Rating INT NOT NULL,
                          Review TEXT,
                          PRIMARY KEY (Beach_Name)
);