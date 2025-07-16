-- 511. Game Play Analysis I

-- Problem Flashcard:
-- - Given a table `Activity` that tracks player activity across multiple days.
-- - Each row represents a login session by a player on a certain device and date.
-- - We are to find the **first login date** for each `player_id`.

-- Approach:
-- - Use the `MIN()` aggregation function to find the earliest `event_date` for each player.
-- - Group the data by `player_id` to get each player's individual login records.

SELECT 
  player_id, 
  MIN(event_date) AS first_login  -- Aggregates the earliest login date per player
FROM 
  Activity
GROUP BY 
  player_id;  -- Groups by player to compute MIN for each player separately

-- Time Complexity: O(n), where n is the number of records in the Activity table (for scan and group aggregation)
-- Space Complexity: O(p), where p is the number of unique player_id values (for storing grouped results)
