CREATE SCHEMA IF NOT EXISTS public;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS user_address
(
    user_address_id uuid    NOT NULL DEFAULT uuid_generate_v4(),
    uid             uuid    NOT NULL,
    address_line_1  varchar NOT NULL,
    city            varchar NOT NULL,
    county          varchar NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (user_address_id),
    CONSTRAINT uq_uid UNIQUE (uid)
);
