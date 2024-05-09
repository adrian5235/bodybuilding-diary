--liquibase formatted sql
--changeset adrian:1
create table weeks (
    id smallserial primary key,
    average_weight float null default 0,
    average_kcal int null default 0,
    weight_difference float null default 0,
    calculated_maintenance int null default 0,
    phase_id int not null,
    foreign key (phase_id) references phases(id)
);