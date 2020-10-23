create table if not exists params (
  id    serial primary key,
  name  varchar(2000) unique,
  value timestamp
);
