INSERT INTO rack (machine_id, rack_id, product_code, num_products) values ('fedex-cafeteria-1', 'A11', 'Chips101', 10);
INSERT INTO rack (machine_id, rack_id, product_code, num_products) values ('fedex-cafeteria-1', 'A12', 'ChexMix', 5);
INSERT INTO rack (machine_id, rack_id, product_code, num_products) values ('fedex-cafeteria-1', 'A13', 'Gum', 6);
INSERT INTO rack (machine_id, rack_id, product_code, num_products) values ('fedex-cafeteria-1', 'B11', 'Water', 3);
INSERT INTO rack (machine_id, rack_id, product_code, num_products) values ('fedex-cafeteria-1', 'B12', 'Gatorade', 4);
INSERT INTO rack (machine_id, rack_id, product_code, num_products) values ('fedex-cafeteria-1', 'B13', 'VitWater', 2);

INSERT INTO product (product_code, product_cost) values ('Chips101', 1.00);
INSERT INTO product (product_code, product_cost) values ('ChexMix', 1.00);
INSERT INTO product (product_code, product_cost) values ('gum', 1.50);
INSERT INTO product (product_code, product_cost) values ('Water', 0.75);
INSERT INTO product (product_code, product_cost) values ('Gatorade', 1.25);
INSERT INTO product (product_code, product_cost) values ('VitWater', 1.25);

INSERT INTO vending_machine (machine_id, total_cash, rack_requested, session_amount) values ('fedex-cafeteria-1', 0.00, null, 0.00);