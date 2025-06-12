-- 182. Duplicate Emails
-- Easy

-- ✅ Problem Statement:
-- Given a table `Person` with `id` and `email`, return all duplicate email addresses.
-- The email column is guaranteed to be NOT NULL and lowercase.

-- ✅ Example:
-- Input:
-- +----+---------+
-- | id | email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- Output:
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+

-- ✅ Approach:
-- 1. Group all rows by the email address.
-- 2. Use HAVING clause to filter only those emails which occur more than once.
-- 3. Return only the email column in the result.

SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;

-- ✅ Output Explanation:
-- - 'a@b.com' appears 2 times → included in result.
-- - 'c@d.com' appears only once → not included.

-- ✅ Time Complexity: O(n), where n = number of rows in Person.
-- ✅ Space Complexity: O(1) — just uses grouping, no extra space beyond SQL engine internals.
