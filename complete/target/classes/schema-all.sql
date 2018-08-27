DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

insert into people (first_name, last_name) values ('Jefferson', 'Ferraz');
insert into people (first_name, last_name) values ('Natan', 'Muniz');
