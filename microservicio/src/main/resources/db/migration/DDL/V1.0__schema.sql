create table alquiler (
 id int(11) not null auto_increment,
 nationalId int not null,
 name varchar(45) not null,
 dob date not null,
 idJetSki varchar not null,
 rentTime int not null,
 dateAndTimeRent date not null,
 primary key (id)
);

create table JetSki (
 id int(11) not null auto_increment,
 IdJetSKi int not null,
 primary key (id)
);

create table pagos (
 id int(11) not null auto_increment,
 idJetSKi int not null,
 rentTime int not null,
 totalPay float not null,
 nationalId int not null
 primary key (id)
);

insert into JetSki (idJetSki) values ('BC001');
insert into JetSki (idJetSki) values ('BC002');
insert into JetSki (idJetSki) values ('BC003');



