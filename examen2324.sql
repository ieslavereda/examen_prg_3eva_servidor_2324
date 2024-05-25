#---------------------------------------------------------- 
#-- Creamos la BD y tablespace 
#---------------------------------------------------------- 
DROP DATABASE IF EXISTS examenPRG2324;
CREATE DATABASE examenPRG2324;
USE examenPRG2324;

#---------------------------------------------------------- 
#-- Creamos un usuario para el acceso a la base de datos 
#---------------------------------------------------------- 
DROP USER IF EXISTS 'examen'@'%'; 
CREATE USER 'examen'@'%' IDENTIFIED BY '1234'; 
GRANT ALL PRIVILEGES ON examenPRG2324.* TO 'examen'@'%'; 
GRANT ALL PRIVILEGES ON mysql.proc TO 'examen'@'%'; 

#---------------------------------------------------------- 
#-- Creamos la tabla e insertamos datos 
#---------------------------------------------------------- 
CREATE TABLE house(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name varchar(50) not null,
  points INTEGER
);
insert into house values (1, "Gryffindor",50);
insert into house values (2, "Hufflepuff",100);
insert into house values (3, "Ravenclaw",150);
insert into house values (4, "Slytherin",null);

#---------------------------------------------------------- 
#-- Creamos los procedimientos 
#---------------------------------------------------------- 
DELIMITER @@
DROP FUNCTION IF EXISTS createHouse @@  
CREATE DEFINER=`root`@`localhost` FUNCTION `createHouse`(nameIn varchar(50), pointsIn INT) RETURNS int
    DETERMINISTIC
BEGIN

    declare idOut int default -1;
	insert into house(name, points) values (nameIn,pointsIn);
	set idOut = LAST_INSERT_ID();  

RETURN idOut;
END@@

DELIMITER ;

DELIMITER @@
DROP PROCEDURE IF EXISTS getAllHouses @@
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllHouses`()
BEGIN
		select * from house;        
END@@

DELIMITER ;

