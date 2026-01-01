/*Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

/*
By utilizing a fixed-size frequency count array instead of hash maps, we can reduce the constant factors in our solution. 
Since we're dealing only with lowercase English letters, we can use arrays of size 26 to store frequencies.

The idea remains the same as above: maintain a sliding window of length p across the string s, but instead of using two hash maps, use two arrays to track the frequencies. 
This not only brings clarity but also slightly optimizes access and modification times since operations on arrays are generally faster than on hash maps.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Frequency arrays for s and p
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Initialize the frequency arrays
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Sliding window over s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // Check if the current window is an anagram
            if (areArraysEqual(pCount, sCount)) result.add(i);

            // Slide the window
            if (i + p.length() < s.length()) {
                sCount[s.charAt(i) - 'a']--; // Remove old char from the count
                sCount[s.charAt(i + p.length()) - 'a']++; // Add new char to the count
            }
        }

        return result;
    }
    
    private boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

/*
Time Complexity: O(n + m), as we are still looping through both strings in their entirety.
Space Complexity: O(1), due to the constant size of the frequency count arrays (26 elements each).
*/
