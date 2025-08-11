-- Question: 595. Big Countries
-- ------------------------------------------------------
-- Flashcard Quick Notes:
-- What is required? -> Retrieve name, population, and area of countries 
-- that are considered "big".
-- A "big" country has:
--   - area >= 3000000, OR
--   - population >= 25000000
-- Approach -> Simple SELECT with WHERE filtering by given conditions.
-- ------------------------------------------------------

SELECT name, population, area
FROM World
-- Filtering countries that satisfy either the area or population condition
WHERE area >= 3000000 
   OR population >= 25000000;

-- ------------------------------------------------------
-- Time Complexity: O(n) -> Checks each row once
-- Space Complexity: O(1) -> No extra space, just query result
-- ------------------------------------------------------
