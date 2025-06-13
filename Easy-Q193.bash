# 193. Valid Phone Numbers
# Easy

# ✅ Problem Statement:
# Given a text file `file.txt` with one phone number per line,
# write a one-liner Bash script to print only the valid phone numbers.

# A valid phone number must follow one of these formats:
# - xxx-xxx-xxxx
# - (xxx) xxx-xxxx
# where `x` is a digit [0–9].

# ✅ Example `file.txt`:
# 987-123-4567      ← valid
# 123 456 7890      ← invalid (wrong format)
# (123) 456-7890    ← valid

# ✅ One-liner Solution (Bash):

grep -E "^([0-9]{3}-[0-9]{3}-[0-9]{4}|\([0-9]{3}\) [0-9]{3}-[0-9]{4})$" file.txt

# ✅ Explanation:
# - `^` and `$` → Anchors to match the entire line
# - `|` → OR operator to match either of the two formats
# - `[0-9]{3}` → Exactly 3 digits
# - `-` or ` ` or `()` → Match hyphen, space, or parentheses literally
# - `-E` → Enables extended regex (so we can use `{}` and `|` without escaping)

# ✅ Output (from the above example):
# 987-123-4567
# (123) 456-7890

# 💡 Tip:
# If your `grep` version doesn't support `-E`, use `egrep` instead:
# egrep "^([0-9]{3}-[0-9]{3}-[0-9]{4}|\([0-9]{3}\) [0-9]{3}-[0-9]{4})$" file.txt
