CREATE TABLE transaction (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGINT,
    type VARCHAR(50) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    timestamp TIMESTAMP,

    CONSTRAINT fk_account
        FOREIGN KEY(account_id)
        REFERENCES account(id)
        ON DELETE SET NULL
);