-- 181. Employees Earning More Than Their Managers
-- Easy

-- ✅ Problem Statement:
-- You are given a table `Employee` with each employee's ID, name, salary, and their manager's ID.
-- Write a query to find all employees who earn **more than their manager**.

-- ✅ Table Schema:
-- Employee(id, name, salary, managerId)

-- ✅ Example:
-- Input:
-- +----+-------+--------+-----------+
-- | id | name  | salary | managerId |
-- +----+-------+--------+-----------+
-- | 1  | Joe   | 70000  | 3         |
-- | 2  | Henry | 80000  | 4         |
-- | 3  | Sam   | 60000  | NULL      |
-- | 4  | Max   | 90000  | NULL      |
-- +----+-------+--------+-----------+
-- Output:
-- +----------+
-- | Employee |
-- +----------+
-- | Joe      |
-- +----------+

-- ✅ Approach:
-- 1. Self-join the Employee table with itself:
--    - Alias one as 'Worker' and the other as 'Manager'.
-- 2. Join condition: `Worker.managerId = Manager.id`
-- 3. In the WHERE clause, filter employees whose salary is greater than their manager's.
-- 4. Select only the name of such employees.

SELECT
  Worker.name AS Employee
FROM
  Employee AS Worker
  INNER JOIN Employee AS Manager
    ON Worker.managerId = Manager.id
WHERE
  Worker.salary > Manager.salary;

-- ✅ Explanation:
-- - We compare each employee with their manager using a self-join.
-- - If the employee's salary is higher than their manager's, we include their name in the output.

-- ✅ Time Complexity: O(n^2) in worst-case for self-join
-- ✅ Space Complexity: O(1), no additional memory used

-- 💡 Tip:
-- Self-joins are useful when you want to compare rows within the same table.
