drop  database IF EXISTS shbd_cors;
create database shbd_cors;
use shbd_cors;
GRANT ALL ON shbd_cors.* to 'shbd'@'localhost' IDENTIFIED BY 'shbd123';
create table t_province(
	id int(10) primary key auto_increment,
	name varchar(100)	
);
create table t_city(
	id int(10) primary key auto_increment,
	name varchar(100),
	city_id int(10),
	CONSTRAINT FOREIGN KEY(city_id) REFERENCES t_province(id)
)