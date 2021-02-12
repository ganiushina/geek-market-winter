drop table if exists products_categories ;
drop table if exists products ;
drop table if exists categories ;
DROP TABLE IF EXISTS products_images;
DROP TABLE IF EXISTS orders_statuses;
DROP TABLE IF EXISTS delivery_addresses;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orders_item;



create table products
    (id int IDENTITY,
     category_id           INT NOT NULL,
     vendor_code           VARCHAR(8) NOT NULL,
     title                 VARCHAR(255) NOT NULL,
     short_description     VARCHAR(1000) NOT NULL,
     full_description      VARCHAR(5000) NOT NULL,
     price                 DECIMAL(8,2) NOT NULL,
     create_at             datetime ,
     update_at             datetime ,
    primary key(id));

CREATE TABLE delivery_addresses (
                                    id	                INT NOT NULL IDENTITY,
                                    user_id               INT NOT NULL,
                                    address               VARCHAR(500) NOT NULL,
                                    PRIMARY KEY (id)
--                                     CONSTRAINT FK_USER_ID_DEL_ADR FOREIGN KEY (user_id)
--                                         REFERENCES users (id)
);

INSERT INTO products (category_id, vendor_code, title, short_description, full_description, price)
VALUES
(1, '00000001', '20\ Телевизор Samsung UE20NU7170U', 'Коротко: Хороший телевизор Samsung 20', 'LED телевизор Samsung 20', 1.00),
(1, '00000002', '24\ Телевизор Samsung UE24NU7170U', 'Коротко: Хороший телевизор Samsung 24', 'LED телевизор Samsung 24', 2.00),
(1, '00000003', '28\ Телевизор Samsung UE28NU7170U', 'Коротко: Хороший телевизор Samsung 28', 'LED телевизор Samsung 28', 3.00),
(1, '00000004', '32\ Телевизор Samsung UE32NU7170U', 'Коротко: Хороший телевизор Samsung 32', 'LED телевизор Samsung 32', 4.00),
(1, '00000005', '36\ Телевизор Samsung UE36NU7170U', 'Коротко: Хороший телевизор Samsung 36', 'LED телевизор Samsung 36', 5.00),
(1, '00000006', '40\ Телевизор Samsung UE40NU7170U', 'Коротко: Хороший телевизор Samsung 40', 'LED телевизор Samsung 40', 6.00),
(1, '00000007', '44\ Телевизор Samsung UE44NU7170U', 'Коротко: Хороший телевизор Samsung 44', 'LED телевизор Samsung 44', 7.00),
(1, '00000008', '48\ Телевизор Samsung UE48NU7170U', 'Коротко: Хороший телевизор Samsung 48', 'LED телевизор Samsung 48', 8.00),
(1, '00000009', '52\ Телевизор Samsung UE52NU7170U', 'Коротко: Хороший телевизор Samsung 52', 'LED телевизор Samsung 52', 9.00),
(1, '00000010', '56\ Телевизор Samsung UE56NU7170U', 'Коротко: Хороший телевизор Samsung 56', 'LED телевизор Samsung 56', 10.00),
(1, '00000011', '60\ Телевизор Samsung UE60NU7170U', 'Коротко: Хороший телевизор Samsung 60', 'LED телевизор Samsung 60', 11.00),
(1, '00000012', '64\ Телевизор Samsung UE64NU7170U', 'Коротко: Хороший телевизор Samsung 64', 'LED телевизор Samsung 64', 12.00);

CREATE TABLE products_images (
                                 id                    INT NOT NULL IDENTITY,
                                 product_id            INT NOT NULL,
                                 path                  VARCHAR(250) NOT NULL,
                                 PRIMARY KEY (id)
--                                  CONSTRAINT FK_PRODUCT_ID_IMG FOREIGN KEY (product_id)
--                                      REFERENCES products (id)
);

CREATE TABLE orders_statuses (
                                 id                    INT NOT NULL IDENTITY ,
                                 title                 VARCHAR(50) DEFAULT NULL,
                                 PRIMARY KEY (id)
);

CREATE TABLE orders (
                        id	                INT NOT NULL IDENTITY ,
                        user_id               INT NOT NULL,
                        price                 DECIMAL(8,2) NOT NULL,
                        delivery_price        DECIMAL(8,2) NOT NULL,
                        delivery_address_id   INT NOT NULL,
                        phone_number          VARCHAR(20) NOT NULL,
                        status_id             INT NOT NULL,
                        delivery_date         datetime ,
                        create_at             datetime  ,
                        update_at             datetime  ,
                        PRIMARY KEY (id)
--                         CONSTRAINT FK_USER_ID FOREIGN KEY (user_id)
--                             REFERENCES users (id),
--                         CONSTRAINT FK_STATUS_ID FOREIGN KEY (status_id)
--                             REFERENCES orders_statuses (id),
--                         CONSTRAINT FK_DELIVERY_ADDRESS_ID FOREIGN KEY (delivery_address_id)
--                             REFERENCES delivery_addresses (id)
);
CREATE TABLE orders_item (
                             id	                INT NOT NULL Identity,
                             product_id            INT NOT NULL,
                             order_id              INT NOT NULL,
                             quantity              INT NOT NULL,
                             item_price            DECIMAL(8,2) NOT NULL,
                             total_price           DECIMAL(8,2) NOT NULL,
                             PRIMARY KEY (id)
--                              CONSTRAINT FK_ORDER_ID FOREIGN KEY (order_id)
--                                  REFERENCES orders (id),
--                              CONSTRAINT FK_PRODUCT_ID_ORD_IT FOREIGN KEY (product_id)
--                                  REFERENCES products (id)
);

create table categories (id int IDENTITY, title varchar(255), description VARCHAR(5000), primary key(id));
INSERT INTO categories (title)
VALUES
('Телевизоры'), ('Ноутбуки');

INSERT INTO orders_statuses (title)
VALUES
('Сформирован');

INSERT INTO products_images (product_id, path)
VALUES
(2, '2.jpg');

INSERT INTO delivery_addresses (user_id, address)
VALUES
(1, '18a Diagon Alley'),
(1, '4 Privet Drive');

create table products_categories
(product_id int not null,
category_id int not null
--primary key(product_id, category_id)
-- foreign key (product_id) references products(id) ,
-- foreign key (category_id) references categories(id)
) ;

insert into products_categories (product_id, category_id) values (1, 1), (2, 1), (3, 1), (4, 2);
