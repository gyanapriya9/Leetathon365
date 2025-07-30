-- 586. Customer Placing the Largest Number of Orders

-- Flashcard Explanation:
-- Task: Return the customer_number of the customer who has placed the most orders.
-- Approach: Group by customer_number, count the number of orders per customer,
-- then order the result in descending order by the count and pick the top one using LIMIT.

SELECT customer_number
FROM Orders
-- Grouping the rows by customer_number so we can count how many orders each customer made
GROUP BY customer_number
-- Sorting the grouped results in descending order of order count
ORDER BY COUNT(*) DESC
-- Picking only the top customer with the maximum order count
LIMIT 1;

-- Time Complexity: O(n log n), where n is the number of rows in the Orders table (due to GROUP BY and ORDER BY)
-- Space Complexity: O(n), for storing intermediate grouped results
