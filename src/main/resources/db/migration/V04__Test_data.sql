insert into users(username, password, email)
VALUES
    ('polzovatel', 'asd123', 'andrei439@mail.ru'),
    ('vechaslavoo', 'cn2krti', 'vech41@mail.ru'),
    ('user345', 'asdfghjkl', 'cxzgf@gmail.com');

insert into flights(point_of_departure, arrival_point, departure_date, arrival_date, price, total_seats)
VALUES
    ('Minsk', 'Paris', '2023-08-15 15:00:00', '2023-08-16 09:00:00', 850, 3),
    ('Brest', 'Tokyo', '2023-09-29 12:00:00', '2023-09-30 17:00:00', 1120, 126);

insert into booking_history(flight_id, user_id)
VALUES
    (1, 2),
    (2, 1),
    (1, 1),
    (1, 3);