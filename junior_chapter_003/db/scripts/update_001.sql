create table if not exists items (
  id          serial primary key,
  name        varchar(2000),
  description varchar(2000),
  create_date timestamptz
)
