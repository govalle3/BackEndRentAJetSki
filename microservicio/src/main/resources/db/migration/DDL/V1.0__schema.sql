create table alquiler (
 nationalId int(11) not null auto-increment,
 name varchar(100) not null,
 dob date not null,
 idJetSki varchar(10) not null,
 rentTime int not null,
 dateAndTimeRent date not null
 primary key (nationalId)
);