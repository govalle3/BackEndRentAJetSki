create table alquiler (
 id int(11) not null auto_increment,
 nationalId int not null,
 name varchar(45) not null,
 dob date not null,
 idJetSki varchar not null,
 rentTime int not null,
 dateAndTimeRent datetime not null,
 estado bool not null,
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



