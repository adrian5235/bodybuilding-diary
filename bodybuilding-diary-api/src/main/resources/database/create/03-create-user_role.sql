--liquibase formatted sql
--changeset adrian:1
create table user_role (
    id smallserial primary key,
    user_id int not null,
    role_id int not null,
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);