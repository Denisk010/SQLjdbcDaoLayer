SELECT product_name FROM netology.CUSTOMERS
JOIN netology.ORDERS ON CUSTOMERS.id = ORDERS.customer_id
WHERE name = :name