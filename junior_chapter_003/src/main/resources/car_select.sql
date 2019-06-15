-- 1. Вывести список всех машин и все привязанные к ним детали.

select c.name, b.type body_type, m.fuel fuel_type, t.type transmission_type
from car c left join body b on c.body_id = b.id
left join motor m on c.motor_id = m.id
left join transmission t on c.transmission_id = t.id;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.

select b.type
from car c right join body b on c.body_id = b.id
where c.id isnull;

select m.fuel
from car c right join motor m on c.motor_id = m.id
where c.id isnull;

select t.type
from car c right join transmission t on c.transmission_id = t.id
where c.id isnull;
