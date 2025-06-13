# 195. Tenth Line
# Easy

# ✅ Problem Statement:
# Given a text file `file.txt`, print just the **10th line** of the file.

# ✅ Example:
# If file.txt contains:
# Line 1
# Line 2
# ...
# Line 10
# Output should be:
# Line 10

# ✅ One-liner Solution using `awk`:
awk 'NR == 10' file.txt

# ✅ Explanation:
# - `awk` processes the file line by line.
# - `NR` stands for "Number of Records" (i.e., the current line number).
# - The command prints only the line where `NR` equals 10.

# ✅ Alternate Solutions:

# 1️⃣ Using `sed`:
sed -n '10p' file.txt
# - `-n` disables automatic printing.
# - `'10p'` tells `sed` to print only the 10th line.

# 2️⃣ Using `head` and `tail`:
head -n 10 file.txt | tail -n 1
# - `head -n 10` gets the first 10 lines.
# - `tail -n 1` then gets the 10th line from that subset.

# ⚠️ Note:
# If `file.txt` contains fewer than 10 lines, all methods will return nothing (empty output), which is expected behavior.

# ✅ Output:
# Line 10
