DROP TABLE IF EXISTS manufactures;
CREATE TABLE IF NOT EXISTS manufactures
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(200) NOT NULL ,
    address VARCHAR(200) NOT NULL,
    phone_id BIGSERIAL
);
-- DROP TABLE IF EXISTS phones;
-- CREATE TABLE IF NOT EXISTS phones
-- (
--     id BIGSERIAL PRIMARY KEY ,
--     name VARCHAR(200) NOT NULL ,
--     creation_year VARCHAR(4) NOT NULL
-- );