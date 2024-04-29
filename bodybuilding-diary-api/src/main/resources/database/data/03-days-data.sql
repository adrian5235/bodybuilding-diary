--liquibase formatted sql
--changeset adrian:1
insert into days (weight, kcal, week_id)
values
(82.6, 2500, 1),
(83.2, 2700, 1),
(83.1, 2700, 1),
(83.2, 3000, 1),
(84.2, 2700, 1),
(84.4, 2700, 1),
(84.2, 2700, 1),
(84.2, 2700, 2),
(84.1, 2700, 2);