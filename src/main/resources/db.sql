CREATE TABLE ISSUE
(
    id              SERIAL PRIMARY KEY,
    description		VARCHAR(300),
    created     	TIMESTAMP DEFAULT NOW()
);