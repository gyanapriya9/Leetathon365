// 1233. Remove Sub-Folders from the Filesystem

/*
Flashcard:
Question asks to remove all sub-folders from a list of folder paths.
A sub-folder is defined as any path that starts with another path + '/'.
We need to return only parent folders.

Approach:
- Sort the folder list lexicographically so that parent folders come before subfolders.
- Iterate through sorted list and keep track of the latest added parent folder.
- Skip adding any folder that is a sub-folder of the last added parent.

Key actions inside the loop:
- If current folder starts with 'prev' and immediately follows with '/', it's a sub-folder -> skip it.
- Else, add to result list and update 'prev'.

Time Complexity: O(n log n) — for sorting the list
Space Complexity: O(n) — for storing the result list
*/

class Solution {
  public List<String> removeSubfolders(String[] folder) {
    List<String> ans = new ArrayList<>();  // to store the final list of parent folders
    String prev = "";  // holds the last added folder path to compare with current

    Arrays.sort(folder);  // sorting ensures parent folder comes before its sub-folders

    for (final String f : folder) {
      // if current folder starts with prev and has '/' immediately after prev, it's a sub-folder
      if (!prev.isEmpty() && f.startsWith(prev) && f.charAt(prev.length()) == '/')
        continue;  // skip sub-folders
      ans.add(f);  // add current as it's a parent folder
      prev = f;    // update prev to current
    }

    return ans;
  }
}
