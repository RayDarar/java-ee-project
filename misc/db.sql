create database java_ee_project;
use java_ee_project;

create table users (
    id integer auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(50) not null,
    firstName varchar(50) not null,
    lastName varchar(50) not null
);

create table posts (
    id integer auto_increment primary key,
    text varchar(400) not null,
    creationDate datetime default now(),
    userId integer not null,
    foreign key(userId) references users(id)
    on delete cascade
);

create table comments (
    id integer auto_increment primary key,
    text varchar(200) not null,
    creationDate datetime default now(),
    postId integer not null,
    userId integer not null,
    foreign key(postId) references posts(id)
    on delete cascade,
    foreign key(userId) references users(id)
    on delete cascade
);

drop table comments;
drop table posts;

insert into users(username, password, firstName, lastName) values ('raydarar', 'awdawdawd', 'Ansar', 'Ryspekov');
insert into posts(text, userId) values('Wow, this is a test post', 4);
insert into comments(text, postId, userId) values('Nice one!', 1, 4);

select * from users;
select * from posts;
select * from comments;
delete from users
where username = 'raydarar';



















