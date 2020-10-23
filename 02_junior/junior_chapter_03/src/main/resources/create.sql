create database request;

\connect request

SET client_encoding TO 'UTF8';

create table roles (
	id serial primary key,
	role varchar(2000) unique 
);

create table rules (
	id serial primary key,
	rule varchar(2000) unique 
);

create table roles_rules (
	role_id int references roles(id),
	rule_id int references rules(id),
	PRIMARY KEY (role_id, rule_id)
);

create table users (
	id serial primary key,
	username varchar(2000) unique,
	role_id int references roles(id)
);

create table categories (
	id serial primary key,
	category varchar(2000) unique 
);

create table states (
	id serial primary key,
	state varchar(2000) unique 
);

create table items (
	id serial primary key,
	item varchar(2000) unique,
	create_user_id int references users(id),
	execute_user_id int references users(id),
	category_id int references categories(id),
	state_id int references states(id)
);

create table comments (
	id serial primary key,
	comment text,
	user_id int references users(id),
	item_id int references items(id)
);

create table attaches (
	id serial primary key,
	attach bytea,
	item_id int references items(id)
);

insert into roles(role) values ('Системный администратор');
insert into roles(role) values ('Сетевой администратор');
insert into roles(role) values ('Инженер-системотехник');
insert into roles(role) values ('Начальник отдела');
insert into roles(role) values ('Пользователь');

insert into rules(rule) values ('Создание');
insert into rules(rule) values ('Комментирование');
insert into rules(rule) values ('Делегирование');
insert into rules(rule) values ('Закрытие');
insert into rules(rule) values ('Удаление');

insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Пользователь' and rule = 'Создание';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Пользователь' and rule = 'Комментирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Начальник отдела' and rule = 'Удаление';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Начальник отдела' and rule = 'Делегирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Начальник отдела' and rule = 'Закрытие';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Системный администратор' and rule = 'Комментирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Системный администратор' and rule = 'Закрытие';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Системный администратор' and rule = 'Делегирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Сетевой администратор' and rule = 'Комментирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Сетевой администратор' and rule = 'Закрытие';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Сетевой администратор' and rule = 'Делегирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Инженер-системотехник' and rule = 'Комментирование';
insert into roles_rules(role_id, rule_id) select roles.id, rules.id from roles, rules where role = 'Инженер-системотехник' and rule = 'Закрытие';

insert into users(username, role_id) select 'Иванов', roles.id from roles where role = 'Системный администратор';
insert into users(username, role_id) select 'Петров', roles.id from roles where role = 'Сетевой администратор';
insert into users(username, role_id) select 'Сидоров', roles.id from roles where role = 'Инженер-системотехник';
insert into users(username, role_id) select 'Царёв', roles.id from roles where role = 'Начальник отдела';
insert into users(username, role_id) select 'Пчёлкина', roles.id from roles where role = 'Пользователь';
insert into users(username, role_id) select 'Хохлова', roles.id from roles where role = 'Пользователь';

insert into categories(category) values ('Обслуживание оргтехники');
insert into categories(category) values ('Установка и настройка ОС');
insert into categories(category) values ('Настройка почты и интернет');
insert into categories(category) values ('Подключение к локальной сети');

insert into states(state) values ('Новая');
insert into states(state) values ('Принята в работу');
insert into states(state) values ('Отменена пользователем');
insert into states(state) values ('Закрыта');

with cr_users as (select * from users), ex_users as (select * from users)
insert into items(item, create_user_id, execute_user_id, category_id, state_id)
select 'Подключить принтер', cr_users.id, ex_users.id, categories.id, states.id
from cr_users, ex_users, categories, states
where cr_users.username = 'Пчёлкина' and ex_users.username = 'Сидоров' and category = 'Обслуживание оргтехники' and state = 'Новая';

with cr_users as (select * from users), ex_users as (select * from users)
insert into items(item, create_user_id, execute_user_id, category_id, state_id)
select 'Настроить почту', cr_users.id, ex_users.id, categories.id, states.id
from cr_users, ex_users, categories, states
where cr_users.username = 'Хохлова' and ex_users.username = 'Петров' and category = 'Настройка почты и интернет' and state = 'Новая';

with cr_users as (select * from users), ex_users as (select * from users)
insert into items(item, create_user_id, execute_user_id, category_id, state_id)
select 'Переустановить систему', cr_users.id, ex_users.id, categories.id, states.id
from cr_users, ex_users, categories, states
where cr_users.username = 'Пчёлкина' and ex_users.username = 'Сидоров' and category = 'Установка и настройка ОС' and state = 'Новая';

insert into comments(comment, user_id, item_id) select 'Просьба исполнить заявку в течении дня', users.id, items.id from users, items
where username = 'Пчёлкина' and item = 'Подключить принтер';
insert into comments(comment, user_id, item_id) select 'Будет настроена к концу завтрашнего дня', users.id, items.id from users, items
where username = 'Иванов' and item = 'Настроить почту';
