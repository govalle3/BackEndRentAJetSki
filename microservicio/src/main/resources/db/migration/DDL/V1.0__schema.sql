create table alquiler (
 nationalId int not null,
 name varchar(45) not null,
 dob date not null,
 idJetSki varchar not null,
 rentTime int not null,
 dateAndTimeRent date not null,
 primary key (nationalId)
);