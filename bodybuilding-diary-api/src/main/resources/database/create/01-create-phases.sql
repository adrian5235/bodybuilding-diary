--liquibase formatted sql
--changeset adrian:1
create table phases (
    id smallserial primary key,
    name varchar(255) not null
);