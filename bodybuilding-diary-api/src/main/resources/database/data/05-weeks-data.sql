--liquibase formatted sql
--changeset adrian:1
insert into weeks (average_weight, average_kcal, weight_difference, calculated_maintenance, phase_id)
values
(83.6, 2700, -0.2, 3000, 2),
(83.4, 2700, -0.1, 3050, 2);