--liquibase formatted sql
--changeset adrian:1
insert into users (first_name, last_name, email, password, enabled)
values
('User', 'Localhost', 'user@localhost', '$2a$10$kPBQqin6njoumN5E9W98TO9rlBYVhXQEttjakH8DgBwgRzAmc1vqy', true);