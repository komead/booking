insert into users(username, password, email)
VALUES
    ('polzovatel', '$2a$10$xlPCn7vfBBq9jQTFJVGz.emughvJXPf2GMuq55S0Tuw7ZuK2Zghdu', 'andrei439@mail.ru'),
    ('vechaslavoo', 'cn2krti', 'vech41@mail.ru'),
    ('user345', '$2a$10$hhTvV3MTGw82IyWtR7VyUuczkTd5xPQMZaGuQRKy0smyAkoMH4XxW', 'cxzgf@gmail.com');

insert into flights(point_of_departure, arrival_point, total_seats)
VALUES
    ('Minsk', 'Paris', 3),
    ('Brest', 'Tokyo', 126);

insert into booking_history(flight_id, user_id)
VALUES
    (1, 2),
    (2, 1),
    (1, 1),
    (1, 3);