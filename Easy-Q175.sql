-- 175. Combine Two Tables
-- Goal: Return firstName, lastName, city, and state for each person.
-- If a person doesn't have an address, return NULL for city and state.

SELECT
  Person.firstName,  -- Select first name from Person table
  Person.lastName,   -- Select last name from Person table
  Address.city,      -- Select city from Address table (can be NULL if no match)
  Address.state      -- Select state from Address table (can be NULL if no match)
FROM Person
LEFT JOIN Address     -- Use LEFT JOIN to include all rows from Person
  ON Person.personId = Address.personId;  -- Match rows by personId
