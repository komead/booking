create table users
(
    id int auto_increment,
    username varchar(16) unique not null,
    password varchar(32) not null,
    email varchar(32) unique not null,
    primary key (id)
);