--liquibase formatted sql
--changeset adrian:1
create table roles (
    id smallserial primary key,
    name varchar(255) not null,
    created_at timestamp null default now(),
    last_modified_on date null
);