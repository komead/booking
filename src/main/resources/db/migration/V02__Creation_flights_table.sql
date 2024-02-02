create table flights
(
    id int auto_increment,
    point_of_departure varchar(20) not null,
    arrival_point varchar(20) not null,
    total_seats int,
    primary key (id)
    );