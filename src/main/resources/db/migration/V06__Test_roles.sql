update users
set role = 'ADMIN'
where username = 'polzovatel';

update users
set role = 'USER'
where username in ('vechaslavoo', 'user345');