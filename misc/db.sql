create database java_ee_project;
use java_ee_project;

CREATE TABLE users (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
select * from users;

insert into users(name) values('User-1');
insert into users(name) values('User-2');
insert into users(name) values('User-3');
insert into users(name) values('User-4');

drop table users;