--liquibase formatted sql
--changeset adrian:1
insert into phases (id, name)
values (1, "cut01");
insert into phases (id, name)
values (2, "recomp01");