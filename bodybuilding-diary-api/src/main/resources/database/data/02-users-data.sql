--liquibase formatted sql
--changeset adrian:1
insert into users (first_name, last_name, email, password, enabled)
values
('User', 'Localhost', 'user@localhost', '12345678', true);