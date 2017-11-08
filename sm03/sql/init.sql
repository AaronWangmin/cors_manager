drop database shbd_cors;
create databe shbd_cors;
use shbd_cors;
GRANT ALL ON shbd_cors.* to 'shbd'@'localhost' IDENTIFIED BY 'shbd123';
create table t_province(
	id int(10) primary key auto_increment,
	name varchar(100)	
);
create table t_city(
	id int(10) primary key auto_increment,
	name varchar(100),
	
)