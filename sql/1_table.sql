CREATE DATABASE tutorial;

-- select tutorial database
\c tutorial;

CREATE TABLE IF NOT EXISTS book (
  id integer NOT NULL,
  name VARCHAR(64) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO book (id, name) VALUES
  (1, 'Harry Potter'),
  (2, 'Test');
