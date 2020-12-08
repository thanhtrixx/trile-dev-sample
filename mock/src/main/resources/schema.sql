DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id          LONG      NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    total_buy_price INT NOT NULL,
    PRIMARY KEY (id)
);
