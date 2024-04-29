--liquibase formatted sql
--changeset adrian:1
insert into phases (name)
values
('cut01'),
('recomp01');