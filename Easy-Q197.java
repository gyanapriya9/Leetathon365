-- 🔢 LeetCode 197: Rising Temperature
-- Difficulty: Easy
-- Goal: Find the ids of days where the temperature is higher than the previous day.

-- 📘 Concept:
-- This is a classic self-join problem.
-- We compare each day's temperature with the previous day's using DATE_SUB.
-- If today's temperature > yesterday's → we return today's id.

-- 🧠 Flashcard-style Recap:
-- 1. Self Join: Join table with itself using aliases.
-- 2. DATE_SUB(): Subtracts a given interval (1 day here) from a date.
-- 3. Compare: today.temperature > yesterday.temperature

-- 🧪 Example:
-- Input Weather table:
-- +----+------------+-------------+
-- | id | recordDate | temperature |
-- +----+------------+-------------+
-- | 1  | 2015-01-01 | 10          |
-- | 2  | 2015-01-02 | 25          |
-- | 3  | 2015-01-03 | 20          |
-- | 4  | 2015-01-04 | 30          |
-- +----+------------+-------------+

-- Output:
-- +----+
-- | id |
-- +----+
-- | 2  |
-- | 4  |
-- +----+

-- Explanation:
-- On 2015-01-02 → 25 > 10 (previous day) → id = 2 ✅
-- On 2015-01-03 → 20 < 25 → ❌
-- On 2015-01-04 → 30 > 20 → id = 4 ✅

-- ✅ SQL Solution:
SELECT today.id
FROM Weather AS today
JOIN Weather AS yesterday
  ON DATE_SUB(today.recordDate, INTERVAL 1 DAY) = yesterday.recordDate
WHERE today.temperature > yesterday.temperature;
