-- 577. Employee Bonus

-- Flashcard Explanation:
-- Goal: Display each employee's name and bonus only if the bonus is less than 1000.
-- Constraint: If the employee has no bonus entry in the Bonus table (i.e., NULL), still include them.
-- Join type: Use LEFT JOIN so all employees are included, even if they don't have a bonus.
-- Filter: Use IFNULL to treat NULL as 0 in the condition `bonus < 1000`.

-- Approach:
-- - Use LEFT JOIN to merge Employee and Bonus on empId.
-- - Use IFNULL to handle missing bonus values.
-- - Apply filter to only include bonuses less than 1000 (including NULLs treated as 0).

SELECT 
  Employee.name,        -- Select the employee's name
  Bonus.bonus           -- Select the employee's bonus (can be NULL)
FROM 
  Employee
LEFT JOIN 
  Bonus
  USING (empId)         -- Join both tables based on empId
WHERE 
  IFNULL(Bonus.bonus, 0) < 1000;  -- Include only if bonus is less than 1000, NULLs treated as 0

-- Time Complexity: O(n), where n is the number of rows in Employee (since we scan it once with join)
-- Space Complexity: O(1) additional space (excluding result set)
