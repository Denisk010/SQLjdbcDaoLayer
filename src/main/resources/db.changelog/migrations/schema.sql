CREATE TABLE netology.customers (
	id serial PRIMARY KEY,
	name VARCHAR(50),
	surname VARCHAR(50),
	age integer,
	phone_number VARCHAR(12)
);

CREATE TABLE netology.orders (
	id serial PRIMARY KEY,
	date DATE,
	customer_id integer,
	product_name VARCHAR(50),
	amount numeric,
	FOREIGN KEY (customer_id) REFERENCES netology.orders (id)
);