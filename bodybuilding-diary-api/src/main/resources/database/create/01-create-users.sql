--liquibase formatted sql
--changeset adrian:1
create table users (
    id smallserial primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) unique not null,
    password varchar(255) not null,
    account_locked boolean null default false,
    enabled boolean null default false,
    created_at timestamp null default now(),
    last_modified_on date null
);