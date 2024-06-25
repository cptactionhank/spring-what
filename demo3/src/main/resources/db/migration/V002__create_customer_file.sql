CREATE TABLE customer_file (
    id BIGSERIAL PRIMARY KEY,
    customer BIGSERIAL NOT NULL REFERENCES customer(id),
    name VARCHAR(255) NOT NULL
);
