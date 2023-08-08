create table flights
(
    id int auto_increment,
    point_of_departure varchar(20) not null,
    arrival_point varchar(20) not null,
    departure_date datetime not null,
    arrival_date datetime not null,
    price varchar(32) not null,
    total_seats int,
    completed bool default false,
    primary key (id)
    );