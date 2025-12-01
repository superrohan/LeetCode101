/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise. 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

class Solution
    boolean isPalindrome(String s) {
        // Step 1: Clean the string using StringBuilder
        StringBuilder cleaned = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        // Step 2: Initialize two pointers
        int left = 0;
        int right = cleaned.length() - 1;
        
        // Step 3: Check palindrome property
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false; // Not a palindrome if any mismatch occurs
            }
            left++;
            right--;
        }
        
        return true; // String is a palindrome
    }
}

/*
The problem requires us to determine if a given string is a palindrome, considering only alphanumeric characters and ignoring cases. The basic idea is to first clean the string by removing all non-alphanumeric characters and converting everything to a consistent case (lowercase). Then, use two pointers to compare characters from the start and end of the string moving inwards.

Steps:
Create a cleaned version of the string that contains only lowercase alphanumeric characters.
Initialize two pointers, one at the start and another at the end of the cleaned string.
Increment and decrement the pointers towards the center, checking if the characters are the same.
If you reach the center with all characters matching, the string is a palindrome.
*/

/*
Time Complexity: O(n), where n is the length of the input string. We traverse each character twice in the worst case (once for cleaning and once for palindrome checking).
Space Complexity: O(n) for the cleaned buffer.
*/
