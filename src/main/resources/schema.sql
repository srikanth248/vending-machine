DROP TABLE IF EXISTS product;

CREATE TABLE product (
    product_code varchar2(20) PRIMARY KEY,
    product_cost Number(3,2)
);

DROP TABLE IF EXISTS rack;

CREATE TABLE rack (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    machine_id varchar2(20),
    rack_id varchar2(20),
    product_code varchar2(20),
    num_products INT
);

DROP TABLE IF EXISTS vending_machine;

CREATE TABLE vending_machine (
    machine_id varchar2(20) PRIMARY KEY,
    total_cash Number(5,2),
    rack_requested varchar2(20),
    session_amount Number(3,2)
);