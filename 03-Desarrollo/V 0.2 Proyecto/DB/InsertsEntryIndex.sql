-- Insertar cuentas
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680102','CC',load_file('C:/proyecto/persona.jpg'),'Andres','Stiven','Gonzales','Gallego','Aprendiz','2017-10-10',false);
insert into DB_ENTRY_INDEX.cuenta VALUES ('97081623485','TI',load_file('C:/PROYECTO/persona.jpg'),'Kevin',null,'Pineda','Morales','Aprendiz','2017-10-10',true);
insert into DB_ENTRY_INDEX.cuenta VALUES ('97081623452','TI',load_file('C:/PROYECTO/persona.jpg'),'Uribe',null,'Moreno',null,'Instructor','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680302','CC',load_file('C:/PROYECTO/persona.jpg'),'Hernando','Enrique','Moreno','Moreno','Instructor','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680456','CC',load_file('C:/PROYECTO/persona.jpg'),'Kevin','Stiven','Pineda','Morales','Psicologo','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680104','CC',load_file('C:/PROYECTO/persona.jpg'),'Peter','David','Gomez','Lobo','Visitante','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680236','CC',load_file('C:/PROYECTO/persona.jpg'),'Oscar','Andres','Hernandez','Ariza','Aprendiz','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680487','CC',load_file('C:/PROYECTO/persona.jpg'),'Yurieth','Patricia','Pedraza','Olarte','Visitante','2017-10-10',false);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680250','CC',load_file('C:/PROYECTO/persona.jpg'),'Edward','Andres','Loaiza','Ortiz','Instructor','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030621348','CC',load_file('C:/PROYECTO/persona.jpg'),'Maritza',null,'Ramires','Fernandez','Aprendiz','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030684230','CC',load_file('C:/PROYECTO/persona.jpg'),'Josue','Francisco','Gomez','Bernal','Funcionario','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680430','CC',load_file('C:/PROYECTO/persona.jpg'),'Yesid','Alejandro','Peña','Galeano','Visitante','2017-10-10',false);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680020','CC',load_file('C:/PROYECTO/persona.jpg'),'Carmen','Lucia','Loaiza','Ortiz','Vigilante','2017-10-10',true);
INSERT INTO DB_ENTRY_INDEX.cuenta VALUES ('1030680147','CC',load_file('C:/PROYECTO/persona.jpg'),'Andres','Santiago','Murillo','Pinzon','Vigilante','2017-10-10',false);

-- Insertar usuarios
insert into DB_ENTRY_INDEX.usuario  values ('Andres_santiago@elejemplo.com',sha1('contrasuma'),'Celador','1030680147','CC',true);
insert into DB_ENTRY_INDEX.usuario values ('Oscar_Hernandez@elejemplo.com',sha1('patito123'),'Administrador','1030680236','CC',true);

-- insertar computadores(Equipos)
insert into DB_ENTRY_INDEX.equipo values(112233,'Una portatil DELL con i7 y 4 de RAM de color negro',false);
insert into DB_ENTRY_INDEX.equipo values(212233,'Una portatil COMPACT con i5 y 4 de RAM de color blanco',true);
insert into DB_ENTRY_INDEX.equipo values(312233,'Una portatil HP con i7 y 8 de RAM de color azul',true);
insert into DB_ENTRY_INDEX.equipo values(412233,'Una portatil INFINITY con i3 y 4 de RAM con estampado de una calabera',true);
insert into DB_ENTRY_INDEX.equipo values(512233,'Una portatil TOSHIBA con core 2 duo y 2 de RAM de color verde',false);
insert into DB_ENTRY_INDEX.equipo values(612233,'Una portatil SONY con intel celeron y 3 de RAM con estampado de un auto',true);
insert into DB_ENTRY_INDEX.equipo values(712233,'Una portatil APPLE con intel celeron y 4 de RAM de color rosa',true);
insert into DB_ENTRY_INDEX.equipo values(812233,'Una portatil ASUS con amd fx y 4 de RAM de color plateado',true);
insert into DB_ENTRY_INDEX.equipo values(912233,'Una portatil LENOVO con i7 y 6 de RAM de color negro',true);
insert into DB_ENTRY_INDEX.equipo values(102233,'Una portatil ACER con i7 y 12 de RAM con estampado de mario',true);
insert into DB_ENTRY_INDEX.equipo values(123,'Una Portatil GENIUS Roja con i3',true);
insert into DB_ENTRY_INDEX.equipo values(1234,'Una Portatil GENIUS Negra con i4 y 4 Ram',false);
insert into DB_ENTRY_INDEX.equipo values(12345,'Una Portatil COMPUMAX Roja i5 con 8 Ram',true);
insert into DB_ENTRY_INDEX.equipo values(123456,'Una portatil TECNOPC con 6 ram core 2 duo de color azul',true);
insert into DB_ENTRY_INDEX.equipo values(1234567,'Una portatil TECNOPC con 1,4 ram pentium 4 de color verde',true);

-- resgistro
insert into DB_ENTRY_INDEX.registro values (1,'2015-12-11 12:00:00','2015-12-11 06:00:00','1030680102','CC',null,'Aprendiz');
insert into DB_ENTRY_INDEX.registro values (2,'2015-12-11 12:01:00','2015-12-11 06:01:00','97081623485','TI',null,'Aprendiz');
insert into DB_ENTRY_INDEX.registro values (3,'2015-12-11 12:02:00','2015-12-11 06:02:00','97081623452','TI',null,'Instructor');
insert into DB_ENTRY_INDEX.registro values (4,'2015-12-11 12:03:00','2015-12-11 06:03:00','1030680302','CC',null,'Instructor');
insert into DB_ENTRY_INDEX.registro values (5,'2015-12-11 12:04:00','2015-12-11 06:04:00','1030680456','CC',null,'Psicologo');

insert into DB_ENTRY_INDEX.registro values (6,'2015-12-11 12:04:00','2015-12-11 06:14:00','1030680104','CC',null,'Visitante');
insert into DB_ENTRY_INDEX.registro values (7,'2015-12-11 12:04:00','2015-12-11 06:24:00','1030680236','CC',null,'Aprendiz');
insert into DB_ENTRY_INDEX.registro values (8,'2015-12-11 12:04:00','2015-12-11 06:34:00','1030680487','CC',null,'Visitante');
insert into DB_ENTRY_INDEX.registro values (9,'2015-12-11 12:04:00','2015-12-11 06:44:00','1030680250','CC',null,'Instructor');
insert into DB_ENTRY_INDEX.registro values (10,'2015-12-11 12:04:00','2015-12-11 06:54:00','1030621348','cC',null,'Aprendiz');

insert into DB_ENTRY_INDEX.registro values (11,'2015-12-11 12:12:00','2015-12-11 06:14:00','1030684230','CC',null,'Funcionario ');
insert into DB_ENTRY_INDEX.registro values (12,'2015-12-11 12:32:00','2015-12-11 06:24:00','1030680430','CC',null,'Visitante ');
insert into DB_ENTRY_INDEX.registro values (13,'2015-12-11 12:12:00','2015-12-11 06:34:00', '1030680020','CC',null,'Vigilante ');
insert into DB_ENTRY_INDEX.registro values (14,'2015-12-11 12:09:00','2015-12-11 06:44:00','1030680147','CC',null,'Vigilante ');


-- registro equipo 
insert into DB_ENTRY_INDEX.registro_equipo values (1,'2015-12-11 12:04:00',112233,'2015-12-11 06:14:00');
insert into DB_ENTRY_INDEX.registro_equipo values (2,'2015-12-11 12:04:00',212233,'2015-12-11 06:24:00');
insert into DB_ENTRY_INDEX.registro_equipo values (3,'2015-12-11 12:04:00',312233,'2015-12-11 06:34:00');
insert into DB_ENTRY_INDEX.registro_equipo values (4,'2015-12-11 12:04:00',412233,'2015-12-11 06:44:00');
insert into DB_ENTRY_INDEX.registro_equipo values (5,'2015-12-11 12:04:00',512233,'2015-12-11 06:54:00');

insert into DB_ENTRY_INDEX.registro_equipo values (6,'2015-12-11 01:01:00',612233,'2015-12-11 03:14:00');
insert into DB_ENTRY_INDEX.registro_equipo values (7,'2015-12-11 02:01:00',712233,'2015-12-11 03:24:00');
insert into DB_ENTRY_INDEX.registro_equipo values (8,'2015-12-11 01:01:00',812233,'2015-12-11 03:34:00');
insert into DB_ENTRY_INDEX.registro_equipo values (9,'2015-12-11 02:01:00',912233,'2015-12-11 03:44:00');
insert into DB_ENTRY_INDEX.registro_equipo values (10,'2015-12-11 03:01:00',102233,'2015-12-11 04:54:00');

insert into DB_ENTRY_INDEX.registro_equipo values (11,'2015-12-11 12:12:00',123,'2015-12-11 06:14:00');
insert into DB_ENTRY_INDEX.registro_equipo values (12,'2015-12-11 12:32:00',12345,'2015-12-11 06:24:00');
insert into DB_ENTRY_INDEX.registro_equipo values (13,'2015-12-11 12:12:00',123456,'2015-12-11 06:34:00');
insert into DB_ENTRY_INDEX.registro_equipo values (14,'2015-12-11 12:09:00',1234567,'2015-12-11 06:44:00');


-- propietarios

insert into DB_ENTRY_INDEX.PROPIETARIO values('112233','1030680102','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('212233','97081623485','TI');
insert into DB_ENTRY_INDEX.PROPIETARIO values('312233','97081623452','TI');
insert into DB_ENTRY_INDEX.PROPIETARIO values('412233','1030680302','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('512233','1030680456','CC');

insert into DB_ENTRY_INDEX.PROPIETARIO values('612233','1030680104','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('712233','1030680236','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('812233','1030680487','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('912233','1030680250','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('102233','1030621348','CC');

insert into DB_ENTRY_INDEX.PROPIETARIO values('123','1030684230','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('12345','1030680430','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('123456','1030680020','CC');
insert into DB_ENTRY_INDEX.PROPIETARIO values('1234567','1030680147','CC');