CREATE TABLE IF NOT EXISTS req_stat(
    id serial primary key,
    ip text,
    time bigint
);