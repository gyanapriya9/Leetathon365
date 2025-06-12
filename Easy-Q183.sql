-- 183. Customers Who Never Order
-- Easy

-- ✅ Problem Statement:
-- You are given two tables: `Customers` and `Orders`.
-- Write a query to find all **customers who never placed an order**.

-- ✅ Table Schema:
-- Customers(id, name)         -- id is the primary key.
-- Orders(id, customerId)      -- customerId is a foreign key referencing Customers.id

-- ✅ Example:
-- Input:
-- Customers Table:
-- +----+-------+
-- | id | name  |
-- +----+-------+
-- | 1  | Joe   |
-- | 2  | Henry |
-- | 3  | Sam   |
-- | 4  | Max   |
-- +----+-------+
-- Orders Table:
-- +----+------------+
-- | id | customerId |
-- +----+------------+
-- | 1  | 3          |
-- | 2  | 1          |
-- +----+------------+
-- Output:
-- +-----------+
-- | Customers |
-- +-----------+
-- | Henry     |
-- | Max       |
-- +-----------+

-- ✅ Approach:
-- 1. Use a LEFT JOIN to combine Customers with Orders on `Customers.id = Orders.customerId`.
-- 2. After joining, if a customer has **no matching order**, the `Orders.id` will be NULL.
-- 3. Filter those rows where `Orders.id IS NULL` to get customers who never ordered.

SELECT
  Customers.name AS Customers
FROM
  Customers
  LEFT JOIN Orders
    ON Customers.id = Orders.customerId
WHERE
  Orders.id IS NULL;

-- ✅ Explanation:
-- LEFT JOIN keeps all records from `Customers`, and fills with NULLs where no match in `Orders`.
-- Filtering with `WHERE Orders.id IS NULL` ensures we only get customers who never ordered.

-- ✅ Time Complexity: O(n), where n = number of customers
-- ✅ Space Complexity: O(1), no extra space used

-- 💡 Tip:
-- LEFT JOIN + IS NULL is a classic pattern for finding "missing" related records.
