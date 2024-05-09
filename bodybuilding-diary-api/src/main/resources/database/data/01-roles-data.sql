--liquibase formatted sql
--changeset adrian:1
insert into roles (name)
values
('USER');