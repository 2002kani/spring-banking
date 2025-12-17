CREATE TABLE account (
    id BIGSERIAL PRIMARY KEY,
    owner_name VARCHAR(255) NOT NULL,
    balance NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP
);
