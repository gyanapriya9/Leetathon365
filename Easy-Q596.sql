-- Question: 596. Classes With at Least 5 Students
-- Flashcard:
-- Requirement: Find all classes that have at least 5 students.
-- Approach: Use GROUP BY on 'class' and HAVING to filter classes with count >= 5.

SELECT class
FROM Courses
-- Grouping students by their class
GROUP BY class
-- Filtering only those classes where student count is >= 5
HAVING COUNT(*) >= 5;

-- Time Complexity: O(N) - N is the number of rows in Courses
-- Space Complexity: O(K) - K is the number of unique classes
