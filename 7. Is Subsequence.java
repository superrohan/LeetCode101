/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        // Iterate through both strings
        while (i < s.length() && j < t.length()) {
            // If characters match, move the pointer for s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move the pointer for t
            j++;
        }
        // If i is equal to the length of s, all characters of s were found in t
        return i == s.length();
    }
}

/*
To check whether a string s is a subsequence of t, we try to match the characters of s in order while scanning through t. We don’t need to modify either string or use extra space.

We use two pointers:
one pointer moves through s
the other moves through t
As we traverse t, we look for characters that match the current character in s. Whenever we find a match, we advance the pointer in s.

The pointer in t always moves because we are scanning the entire sequence.

If we manage to advance through all characters in s, then every character in s appears in the correct order in t, meaning s is a subsequence of t.

Steps:
Initialize two pointers, i for tracking the current character in s and j for scanning through t
Iterate over t using j.
Whenever s[i] == t[j], increment i because we matched a character of s.
Always increment j because we continue scanning t.
If i reaches the length of s, it means all characters in s have been matched correctly in order within t.
Return true if all characters of s were matched; otherwise return false.
*/

/*
Time Complexity: O(n), where n is the length of the array.
Space Complexity: O(n), due to the use of additional array.
*/
