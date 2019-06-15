-- 1. Написать запрос получение всех продуктов с типом "СЫР"

select product.* from product join type on product.type_id = type.id where type.name = 'Сыр';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

select product.* from product join type on product.type_id = type.id where lower(product.name) like '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

select product.* from product where date_part('month', expired_date) = date_part('month', current_date) + 1;

-- 4. Написать запрос, который выводит самый дорогой продукт.

select product.* from product order by price desc limit 1;

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.

select type.name, count(product.id) from product join type on product.type_id = type.id group by type.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

select product.* from product join type on product.type_id = type.id where type.name in ('Сыр', 'Молоко');

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  

select type.name from product join type on product.type_id = type.id group by type.name having count(product.id) < 10;

-- 8. Вывести все продукты и их тип.

select product.name as product_name, type.name as type_name from product join type on product.type_id = type.id;
