CREATE TABLE movie
(
    id           BIGSERIAL PRIMARY KEY,
    title        VARCHAR(250) NOT NULL,
    description  text,
    release_date DATE,
    rating       numeric,
    created_at   TIMESTAMP,
    updated_at   TIMESTAMP
);