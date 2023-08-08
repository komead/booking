create table booking_history
(
    id int auto_increment,
    flight_id int not null,
    user_id int not null,
    booking_date datetime default current_timestamp,
    primary key (id),
    foreign key (flight_id) references flights (id),
    foreign key (user_id) references users (id)
);