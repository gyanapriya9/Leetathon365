-- 196. Delete Duplicate Emails
-- Easy

-- ✅ Problem Statement:
-- Write an SQL DELETE statement to remove **duplicate emails** from the `Person` table.
-- Only **keep the row with the smallest id** for each duplicate email.

-- ✅ Table Schema:
-- Table: Person
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |  ← Primary Key
-- | email       | varchar |
-- +-------------+---------+

-- ✅ Example:
-- Input:
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Output:
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+

-- ✅ Approach:
-- - Join the table to itself: `P1` and `P2`
-- - Match rows where `P1.email = P2.email` and `P1.id < P2.id`
-- - This ensures we **delete the duplicate rows** that have **higher ids**

DELETE P2
FROM Person AS P1
INNER JOIN Person AS P2
  ON (P1.email = P2.email)
WHERE P1.id < P2.id;

-- ✅ Explanation:
-- - For each duplicate email, keep the one with the smallest id.
-- - The `DELETE` statement removes rows where a **smaller id with the same email** already exists.

-- ⚠️ Note:
-- - This modifies the table in-place.
-- - Final table order doesn’t matter.

-- ✅ Output (after deletion):
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
