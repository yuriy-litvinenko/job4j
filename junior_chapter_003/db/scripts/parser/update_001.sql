create table if not exists vacancy (
  id   serial primary key,
  name varchar(2000) unique,
  text text,
  link varchar(2000)
);
