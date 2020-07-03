USE sistemaRecaudacionCongreso;

INSERT INTO user (id,createdat,enabled,password,updatedat,username,photo) VALUES(1, "2020-03-22 00:00:01", 1, "$2a$10$zUXqm9ehdGj7I6f1M8HNRugErdA5SJ06sJUo7dTLty8q7tbKBklPi", "2020-03-22 00:00:01", "empleado","image-1.jpg");
INSERT INTO user (id,createdat,enabled,password,updatedat,username,photo) VALUES(2, "2020-03-22 00:00:01", 1, "$2a$10$wUbGKY0nzIA9aH9gPZuqOuBNhwTmOmzRBZeMk8L8YHCz.AczonfLG", "2020-03-22 00:00:01", "admin", "image-2.jpg");

INSERT INTO user_role (id,createdat,role,updatedat,user_id) VALUES(1, "2020-03-22 00:00:01", "ROLE_USER", "2020-03-22 00:00:01", 1);
INSERT INTO user_role (id,createdat,role,updatedat,user_id) VALUES(2, "2020-03-22 00:00:01", "ROLE_ADMIN", "2020-03-22 00:00:01", 2);

INSERT INTO persona (id_persona,email,movil) VALUES(1,"Email1@gmail.com",15111111);
INSERT INTO persona (email,movil) VALUES("Email2@gmail.com",15222222);
INSERT INTO persona (email,movil) VALUES("Email3@gmail.com",15333333);
INSERT INTO persona (email,movil) VALUES("Email4@gmail.com",15444444);

INSERT INTO persona (email,movil) VALUES("Email5@gmail.com.ar",15999911);
INSERT INTO persona (email,movil) VALUES("Email6@gmail.com.ar",15999922);
INSERT INTO persona (email,movil) VALUES("Email7@gmail.com.ar",15999933);

INSERT INTO persona (email,movil) VALUES("UNla@edu.com.ar",15555555);
INSERT INTO persona (email,movil) VALUES("UBA@edu.com.ar",15666666);
INSERT INTO persona (email,movil) VALUES("UNLZ@edu.com.ar",15777777);
INSERT INTO persona (email,movil) VALUES("UTN@edu.com.ar",15888888);




INSERT INTO espectador (nombre,apellido,nivel_estudio,tipo_documento,nro_documento,id_persona) VALUES("Bob","Dylan",'Secundario',"DNI",11111111,1);
INSERT INTO espectador (nombre,apellido,nivel_estudio,tipo_documento,nro_documento,id_persona) VALUES("Bruce","Springteen",'Terceario',"DNI",22222222,2);
INSERT INTO espectador (nombre,apellido,nivel_estudio,tipo_documento,nro_documento,id_persona) VALUES("Nick","Rhoades",'Universitario',"LE",33333333,3);
INSERT INTO espectador (nombre,apellido,nivel_estudio,tipo_documento,nro_documento,id_persona) VALUES("John","Taylor",'Universitario',"LE",44444444,4);



INSERT INTO orador(nombre,apellido,area_investigacion,id_persona) VALUES("Philip ","Bailey",'Ciencias Agrarias',5);
INSERT INTO orador(nombre,apellido,area_investigacion,id_persona) VALUES("Susan Ann","Sulley",'Ciencias Agrarias',6);
INSERT INTO orador(nombre,apellido,area_investigacion,id_persona) VALUES("Philip","Oakley",'Informatica',7);


INSERT INTO conferencia(id_conferencia,costo,descripcion,titulo,fecha,orador_id_persona) VALUES(1,20000,"Esta es la Conferencia1","Conferencia1",'2020-09-21',5);
INSERT INTO conferencia(costo,descripcion,titulo,fecha,orador_id_persona) VALUES(30000,"Esta es la Conferencia2","Conferencia2",'2020-10-22',6);
INSERT INTO conferencia(costo,descripcion,titulo,fecha,orador_id_persona) VALUES(50000,"Esta es la Conferencia3","Conferencia3",'2020-11-23',7);



INSERT INTO auspiciante(cuit,monto_aportado,razon_social,id_persona,id_conferencia) VALUES("37-11111111-9",10000,'UNLa',8,1);
INSERT INTO auspiciante(cuit,monto_aportado,razon_social,id_persona,id_conferencia) VALUES("37-22222222-9",15000,'UBA',9,2);
INSERT INTO auspiciante(cuit,monto_aportado,razon_social,id_persona,id_conferencia) VALUES("37-33333333-9",15000,'UNLZ',10,3);
INSERT INTO auspiciante(cuit,monto_aportado,razon_social,id_persona,id_conferencia) VALUES("37-44444444-9",15000,'UTN',11,1);



INSERT INTO entrada(id_entrada,fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES(1,'2020-07-22',1000,1,1);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-22',1000,2,2);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-22',1500,3,3);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-22',1200,1,4);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-23',1200,2,2);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-23',1200,1,2);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-23',1200,3,4);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-24',1250,3,3);
INSERT INTO entrada(fecha_compra,precio,conferencia_id_conferencia,espectador_id_persona) VALUES('2020-07-24',1300,2,1);


