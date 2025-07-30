-- 584. Find Customer Referee

-- Flashcard Explanation:
-- Task: Return the names of customers who are either:
-- 1. Not referred by anyone (referee_id IS NULL), OR
-- 2. Referred by someone whose id is NOT 2.
-- Approach: Use a SELECT query with a WHERE clause that filters customers based on the above two conditions.

SELECT name
FROM Customer
-- Check if the customer was not referred by anyone (referee_id IS NULL)
-- OR the customer was referred by someone whose id is not equal to 2
WHERE referee_id IS NULL OR referee_id != 2;

-- Time Complexity: O(n), where n is the number of rows in the Customer table (full table scan)
-- Space Complexity: O(1), no extra space used apart from the result set
