


/* Populate tables */
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-28');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(2, 'John', 'Doe', 'john.doe@gmail.com', '2017-08-28');


Insert into paises(nombre,foto) values('venezuela','');
Insert into paises(nombre,foto) values('Colombia','');
Insert into paises(nombre,foto) values('Inglaterra','');
Insert into paises(nombre,foto) values('Espana','');
Insert into paises(nombre,foto) values('Alemania','');
Insert into paises(nombre,foto) values('Rusia','');
Insert into paises(nombre,foto) values('Autrias','');
Insert into paises(nombre,foto) values('Polonia','');


Insert into ciudades(codigo_postal,nombre,nombre_pais) values(1,'Liverpool','Inglaterra');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(2,'Caracas','venezuela');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(3,'Medellin','Colombia');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(3,'Denia','Espana');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(4,'Munich','Alemania');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(5,'moscu','Rusia');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(6,'Viena','Austria');
Insert into ciudades(codigo_postal,nombre,nombre_pais) values(7,'varsovia','Polonia');

INSERT INTO agencia_venta_coche (codigo, email, nombre, nume_telefono,ciudad_cod_postal) VALUES (2, 'agencia@gmail.com','Danielcars',28823, 1);
INSERT INTO agencia_venta_coche (codigo, email, nombre, nume_telefono,ciudad_cod_postal) VALUES (3,'agencia@gmail.com', 'Danielcars',82837, 2);
INSERT INTO agencia_venta_coche (codigo, email, nombre, nume_telefono,ciudad_cod_postal) VALUES (4,'agencia@gmail.com', 'Danielcars', 838843,3);
INSERT INTO agencia_venta_coche (codigo, email, nombre, nume_telefono,ciudad_cod_postal) VALUES (5,'agencia@gmail.com', 'Danielcars', 8384843,4);
INSERT INTO agencia_venta_coche (codigo, email, nombre, nume_telefono,ciudad_cod_postal) VALUES (6,'gencia@gmail.com', 'Danielcars', 83848,5);
INSERT INTO agencia_venta_coche (codigo, email, nombre, nume_telefono,ciudad_cod_postal) VALUES (7,'agencia@gmail.com', 'Danielcars', 83838,6);


INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES (1, '2021-02-10', 'Gasolina', 'Toyota', 'Crolla', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 2,'2021-02-10', 'Gasolina', 'Audi', 'A4', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 3,'2021-02-10', 'Gasolina', 'Audi', 'Q7', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 4,'2021-02-10', 'Gasolina', 'BW2', 'X2', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES (5,'2021-02-10', 'Gasolina', 'BORWARD', 'BX7', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES (6,'2021-02-10', 'Gasolina', 'Bentley', 'Aveo', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 7,'2021-02-10', 'Gasolina', 'BMW', 'I8', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 8,'2021-02-10', 'Gasolina', 'Cadillac', 'CTS', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 9,'2021-02-10', 'Gasolina', 'Chevrolet', 'dokker', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES (10,'2021-02-10', 'Gasolina', 'Bugatti', 'Chiron', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES (11,'2021-02-10', 'Gasolina', 'Aston Martin', 'Super7', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 12,'2021-02-10', 'Gasolina', 'Alpine', 'C1', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES (13,'2021-02-10', 'Gasolina', 'Alfa Romeo', 'C3AICROSS', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 14,'2021-02-10', 'Gasolina', 'Abarth', 'Ateca', 4, 'Familiar', 'Manual', 2);
INSERT INTO vehiculo (numero_oferta, anyo_vehiculo, combustible, marca, modelo, num_plazas, tipo, tipo_cambio, cod_agencia) VALUES ( 15,'2021-02-10', 'Gasolina', 'Toyota', '4Ruunner', 4, 'Familiar', 'Manual', 2);
INSERT INTO `anuncio` (`codigo_anuncio`, `fecha_publicacion`, `num_km`, `precio`, `codigo_agencia`, `numero_oferta_vehiculo`) VALUES ('1', '2021-02-17', '6000', '30000', '2', '9'), ('4', '2021-02-17', '123', '343232', '5', '3'), ('5', '2020-06-09', '23123', '322423', '3', '7'), ('6', '2019-09-16', '213213', '324234123', '5', '13'), ('7', '2015-02-22', '123123', '123123', '5', '13'), ('9', '2012-02-01', '2312321', '132143', '4', '14'), ('11', '2010-02-01', '21312', '32423423', '6', '15'), ('12', '2009-02-09', '21312', '23332', '6', '12');


INSERT INTO users(enable,password,username) values(1,'$2a$10$VleR0UMNWdAtVDIQ3oeGkuMOKmovK7mEzyJLVOHnB8Wrn8a.vUzfu','daniel');
INSERT INTO users(enable,password,username) values(1,'$2a$10$pvOkiKc8ShT0kkKPeyP0eOrpGw7KTSSBOnUrsxGmF0l5TsZkYrXKy','admin');


INSERT INTO `authorities` (authority,user_id) values('ROLE_USER',1);


INSERT INTO `authorities` (authority,user_id) values('ROLE_USER',2);
INSERT INTO `authorities` (authority,user_id) values('ROLE_ADMIN',2);
