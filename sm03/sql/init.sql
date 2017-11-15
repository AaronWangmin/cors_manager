drop  database IF EXISTS shbd_cors;
create database shbd_cors;
use shbd_cors;
GRANT ALL ON shbd_cors.* to 'shbd'@'localhost' IDENTIFIED BY 'shbd123';
create table t_province(
	id int(10) primary key auto_increment,
	name varchar(100),
	short_name varchar(100)
);
create table t_city(
	id int(10) primary key auto_increment,
	name varchar(100),
	city_id int(10),
	CONSTRAINT FOREIGN KEY(city_id) REFERENCES t_province(id)
);
create table t_company(
	id int(10) primary key auto_increment,
	name varchar(100),
	address varchar(100),
	type int(10)
);
create table t_user(
	id int(10) primary key auto_increment,
	name varchar(100),
	password varchar(100),
	nickname varchar(100),
	type int(10),
	office varchar(100),
	phone varchar(100),
	company_id int(10),
	CONSTRAINT FOREIGN KEY(company_id) REFERENCES t_company(id)
);
