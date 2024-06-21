CREATE USER crud WITH PASSWORD 'crud';
ALTER USER crud WITH SUPERUSER;

CREATE DATABASE crud;
\c crud;

TRUNCATE todolist;
ALTER SEQUENCE todolist_id_seq RESTART WITH 1;
ALTER SEQUENCE todolist_order_task_seq RESTART WITH 1; 

CREATE TABLE todolist(
    id Serial PRIMARY KEY,
    task VARCHAR,
    order_task Serial UNIQUE,
    status Boolean,
    remind timestamp,
    due timestamp
);

INSERT INTO todolist(task,status,remind,due) VALUES ('make the app',true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO todolist(task,status,remind,due) VALUES ('make a todo list',false,'2024-04-16 23:59:59','2024-04-20 23:59:59');

CREATE TABLE users(
    id Serial PRIMARY KEY,
    name VARCHAR(20),
    password VARCHAR(20)
);

INSERT INTO users(name,password) VALUES ('root','root');