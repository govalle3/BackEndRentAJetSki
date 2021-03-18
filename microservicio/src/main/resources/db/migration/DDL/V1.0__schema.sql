create table alquiler (
 id int(11) not null auto_increment,
 nationalId int not null,
 name varchar(45) not null,
 idJetSki varchar not null,
 rentTime int not null,
 dateAndTimeRent date not null,
 primary key (id)
);