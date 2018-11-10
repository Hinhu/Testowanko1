CREATE DATABASE IF NOT EXISTS testowanie1;

USE testowanie1;

DROP TABLE IF EXISTS rowery;

CREATE TABLE IF NOT EXISTS rowery (
  rower_id int(100) NOT NULL AUTO_INCREMENT,
  nazwa varchar(50) DEFAULT NULL,
  marka varchar(50) DEFAULT NULL,
  rodzaj varchar(50) DEFAULT NULL,  
  cena decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (rower_id)
);

CREATE USER 'testowanieRowery'@'localhost' IDENTIFIED BY 'testowanieRowery';
GRANT ALL PRIVILEGES ON testowanie1. * TO 'testowanieRowery'@'localhost';
ALTER USER 'testowanieRowery'@'localhost' IDENTIFIED WITH mysql_native_password BY 'testowanieRowery';
