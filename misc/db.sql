create database java_ee_project;
use java_ee_project;

create table users (
    id integer auto_increment primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    firstname varchar(50) not null,
    lastname varchar(50) not null
);

create table posts (
    id integer auto_increment primary key,
    text varchar(400) not null,
    creationDate datetime default now(),
    userId integer not null,
    foreign key(userId) references users(id)
);

create table comments (
    id integer auto_increment primary key,
    text varchar(400) not null,
    creationDate datetime default now(),
    postId integer not null,
    foreign key(postId) references posts(id)
);

