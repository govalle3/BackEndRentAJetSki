create table alquiler (
 id int(11) not null auto_increment,
 cedula int(20) not null,
 idJetSki varchar not null,
 tiempoRenta int not null,
 fechaYHoraRenta datetime not null,
 estado boolean not null,
 primary key (id),
);

create table usuarios (
id int(11) not null auto_increment,
cedula int not null,
nombre varchar(40) not null,
fechaNacido date not null,
primary key (id)
);

create table JetSki (
 id int(11) not null auto_increment,
 IdJetSKi varchar not null,
 primary key (id)
);

insert into JetSki (IdJetSKi) values ('BC001');
insert into JetSki (IdJetSKi) values ('BC002');
insert into JetSki (IdJetSKi) values ('BC003');



