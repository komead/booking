insert into users(username, password, email)
VALUES
    ('polzovatel', 'asd123', 'andrei439@mail.ru'),
    ('vechaslavoo', 'cn2krti', 'vech41@mail.ru'),
    ('user345', 'asdfghjkl', 'cxzgf@gmail.com');

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