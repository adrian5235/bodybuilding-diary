--liquibase formatted sql
--changeset adrian:1
create table tokens (
    id smallserial primary key,
    token varchar(255) not null,
    created_at timestamp not null,
    expires_at timestamp not null,
    validated_at timestamp null,
    user_id int not null,
    foreign key (user_id) references users(id)
);