create table body(
  id serial primary key,
  type varchar(200) not null
);

create table motor(
  id serial primary key,
  fuel varchar(200) not null
);

create table transmission(
  id serial primary key,
  type varchar(200) not null
);

create table car(
  id serial primary key,
  name varchar(200),
  body_id int references body(id) not null ,
  motor_id int references motor(id) not null ,
  transmission_id int references transmission(id) not null
);

insert into body (type) values ('Седан');
insert into body (type) values ('Универсал');
insert into body (type) values ('Хэтчбэк');
insert into body (type) values ('Купе');

insert into motor (fuel) values ('Бензин');
insert into motor (fuel) values ('Дизельное топливо');
insert into motor (fuel) values ('Природный газ');

insert into transmission (type) values ('Механическая');
insert into transmission (type) values ('Автоматическая');
insert into transmission (type) values ('Роботизированная');

insert into car (name, body_id, motor_id, transmission_id) values ('Лада Калина', 3, 1, 1);
insert into car (name, body_id, motor_id, transmission_id) values ('Лада Ларгус', 2, 1, 1);
insert into car (name, body_id, motor_id, transmission_id) values ('Лада Приора', 1, 1, 1);
