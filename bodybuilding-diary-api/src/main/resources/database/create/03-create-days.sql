--liquibase formatted sql
--changeset adrian:1
create table days (
    id int auto_increment primary key,
    weight double null,
    kcal int null,
    week_id int not null,
    foreign key (week_id) references weeks(id)
);