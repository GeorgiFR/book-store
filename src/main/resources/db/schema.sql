CREATE TABLE IF NOT EXISTS book (
    id integer PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL
);
