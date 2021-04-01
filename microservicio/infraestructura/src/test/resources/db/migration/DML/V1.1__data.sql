insert into usuarios(cedula,nombre,fechaNacido) values('1098682980','Carlos','1995-05-07');
insert into alquiler(cedula,idJetSki,tiempoRenta,fechaYHoraRenta, estado) values('1098682980','BC001',10,'2021-03-31 09:20:00',1);
update alquiler set estado = 0 where cedula = '1098682980';
insert into alquiler(cedula,idJetSki,tiempoRenta,fechaYHoraRenta, estado) values('1098682980','BC001',10,'2021-03-31 09:20:00',1);
