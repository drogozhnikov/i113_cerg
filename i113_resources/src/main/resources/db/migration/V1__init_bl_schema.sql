create schema if not exists resources;

SET search_path TO resources;

DROP TABLE IF EXISTS languages;

CREATE TABLE IF NOT EXISTS languages
(
    id    SERIAL PRIMARY KEY,
    param VARCHAR(30)  NOT NULL,
    eng   VARCHAR(200) NOT NULL,
    rus   VARCHAR(200) NOT NULL
);




