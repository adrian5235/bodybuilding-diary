--liquibase formatted sql
--changeset adrian:1
create table weeks (
    id int auto_increment primary key,
    average_weight double null default 0,
    average_kcal int null default 0,
    weight_difference double null default 0,
    calculated_maintenance int null default 0,
    phase_id int not null,
    foreign key (phase_id) references phases(id)
);