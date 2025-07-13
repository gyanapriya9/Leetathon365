// 2410. Maximum Matching of Players With Trainers
// Question:
// Given two arrays: players (each with a certain ability) and trainers (each with a training capacity).
// A player can be matched with a trainer if player's ability <= trainer's capacity.
// Each player and trainer can be used only once.
// Task: Return the maximum number of such matchings.

// Approach:
// - Sort both arrays (players and trainers) in ascending order.
// - Use two pointers or a single index to greedily match the weakest available player with the weakest sufficient trainer.
// - Count each valid match.
// - Stop if all players are matched or all trainers are used.

class Solution { 
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    int ans = 0;

    // Sort both arrays to use two-pointer technique for greedy matching
    Arrays.sort(players);
    Arrays.sort(trainers);

    // Iterate through trainers and try to match them with the next unmatched player
    for (int i = 0; i < trainers.length; ++i)
      if (players[ans] <= trainers[i] && ++ans == players.length)
        // If match found and all players matched, return result early
        return ans;

    // Return total number of matches found
    return ans;
  }
}

// Time Complexity: O(n log n + m log m), where n = players.length and m = trainers.length (due to sorting)
// Space Complexity: O(1) extra space (sorting done in-place)
