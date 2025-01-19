CREATE TABLE client(
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    enterpise_name VARCHAR(255) NOT NULL,
    cpnj BIGINT NOT NULL,
    description VARCHAR(255) NULL,
    street_name VARCHAR(255) NULL,
    street_number INT NULL,
    city VARCHAR(255)  NULL,
    state VARCHAR(255)  NULL,
    zip_code BIGINT  NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);