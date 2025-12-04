/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces. 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

class Solution {
    public String reverseWords(String s) {
        // Step 1: Split the input string on spaces
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Use StringBuilder to construct the result efficiently
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }
}

/*
Split the input string by spaces.
Filter out any empty strings resulting from extra spaces.
Reverse the list and join the words into a single string with space separation.
*/

/*
Time Complexity: O(N), where N is the length of the input string, due to splitting and joining operations.
Space Complexity: O(N), used by split.
*/


-------------------------------------------------------------------------------------------------------------------------------------------------------


/*
Reverse the entire character array.
Reverse each word within the array.
Clean up any extra spaces resulting from the reversal process.
*/

class Solution {
    public String reverseWords(String s) {
        // Convert string to char array for in-place modifications
        char[] str = s.toCharArray();

        // Step 1: Reverse entire string
        reverse(str, 0, str.length - 1);

        // Step 2: Reverse each word
        reverseWords(str);

        // Step 3: Clean up spaces and return the cleaned string
        return cleanSpaces(str);
    }

    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }

    private void reverseWords(char[] s) {
        int n = s.length;
        int start = 0;
        for (int end = 0; end < n; end++) {
            // Find the end of the current word
            if (s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1; // Move to the start of the next word
            }
        }
        // Reverse the last word
        reverse(s, start, n - 1);
    }

    private String cleanSpaces(char[] str) {
        int n = str.length;
        int i = 0, j = 0;

        while (j < n) {
            // Skip spaces
            while (j < n && str[j] == ' ') j++;
            // Copy non-space characters
            while (j < n && str[j] != ' ') str[i++] = str[j++];
            // Skip spaces to reach the next word, add only one space if there's a next word
            while (j < n && str[j] == ' ') j++;
            if (j < n) str[i++] = ' ';
        }

        return new String(str, 0, i);
    }
}


/*
Time Complexity: O(N), where N is the length of the string, due to multiple in-place passes.
Space Complexity: O(1), as modifications are performed in-place without extra space allocations outside of the input array.
*/
