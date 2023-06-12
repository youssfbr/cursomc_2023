INSERT INTO tb_category (name, created_at) VALUES ('Informática', NOW());
INSERT INTO tb_category (name, created_at) VALUES ('Escritório', NOW());

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Computador', 2000.0, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Impressora', 800.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Mouse', 80.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 1);

INSERT INTO tb_state (name) VALUES ('Ceará');
INSERT INTO tb_state (name) VALUES ('São Paulo');

INSERT INTO tb_city (name, state_id) VALUES ('Fortaleza', 1);
INSERT INTO tb_city (name, state_id) VALUES ('São Paulo', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Campinas', 2);

INSERT INTO tb_clients (name, email, cpf_or_cnpj, client_status) VALUES ('Alisson Youssf', 'alisson@gmail.com', '123456789', 1);
INSERT INTO tb_phones (phones, client_id) VALUES ('123456789', 1);
INSERT INTO tb_phones (phones, client_id) VALUES ('123456788', 1);
INSERT INTO tb_address(public_place, number, complement, district, cep, client_id, city_id) VALUES ('Rua X', '10578', 'Prox a praia', 'Centro', '60000-00', 1, 1);
INSERT INTO tb_address(public_place, number, complement, district, cep, client_id, city_id) VALUES ('Av. Matos', '105', 'Prox a serra', 'Aldeota', '601400-01', 1, 2);

INSERT INTO tb_order (instant, client_id, delivery_address_id) VALUES (TIMESTAMP WITH TIME ZONE '2017-09-30T10:32:00Z', 1, 1);
INSERT INTO tb_payment (payment_status, order_id) VALUES (2, 1);
INSERT INTO tb_payment_credit_card (number_installments, order_id) VALUES (6, 1);

INSERT INTO tb_order (instant, client_id, delivery_address_id) VALUES (TIMESTAMP WITH TIME ZONE '2017-10-10T19:35:00Z', 1, 2);
INSERT INTO tb_payment (payment_status, order_id) VALUES (1, 2);
INSERT INTO tb_payment_bill (maturity_date, payment_date, order_id) VALUES ('2017-10-10' ,null ,2);

INSERT INTO tb_order_item (discount, price, quantity, order_id, product_id) VALUES (0.0, 2000.0, 1, 1, 1);
INSERT INTO tb_order_item (discount, price, quantity, order_id, product_id) VALUES (0.0, 80.0, 2, 1, 3);
INSERT INTO tb_order_item (discount, price, quantity, order_id, product_id) VALUES (100.0, 800.0, 1, 2, 2);
