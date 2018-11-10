CREATE DATABASE IF NOT EXISTS testowanie1;

USE testowanie1;

DROP TABLE IF EXISTS rowery;

CREATE TABLE IF NOT EXISTS rowery (
  rower_id int(100) NOT NULL AUTO_INCREMENT,
  nazwa varchar(50) DEFAULT NULL,
  marka varchar(50) DEFAULT NULL,
  rodzaj varchar(50) DEFAULT NULL,  
  cena int(100) DEFAULT NULL,
  PRIMARY KEY (rower_id)
);

