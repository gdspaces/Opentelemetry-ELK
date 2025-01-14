-- Creating the Orders table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    postal_code VARCHAR(10) NOT NULL,
    delivery_date DATE
);

-- Creating the Inventory table
CREATE TABLE inventory (
    product_name VARCHAR(255) PRIMARY KEY,
    quantity INTEGER NOT NULL
);

-- Inserting dummy data into the Inventory table
INSERT INTO inventory (product_name, quantity) VALUES 
('Laptop', 50),
('Smartphone', 150),
('Headphones', 75),
('Monitor', 30),
('Keyboard', 100);

-- Creating the Delivery Time table
CREATE TABLE delivery_time (
    postal_code VARCHAR(10) PRIMARY KEY,
    days INTEGER NOT NULL
);

-- Inserting dummy data into the Delivery Time table
INSERT INTO delivery_time (postal_code, days) VALUES 
('12345', 3),
('23456', 5),
('34567', 2),
('45678', 4),
('56789', 6);
