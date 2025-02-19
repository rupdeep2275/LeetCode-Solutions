select c.name as Customers
from customers c
left join orders o
on c.id = o.customerId
where o.customerId is null;

# Write your MySQL query statement below
SELECT name AS Customers
FROM customers
WHERE id NOT IN (
    SELECT customerId
    FROM orders
);
