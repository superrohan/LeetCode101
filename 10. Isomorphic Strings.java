/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself. 

Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "foo", t = "bar"
Output: false
Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:
Input: s = "paper", t = "title"
Output: true
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Check if previous mapped characters are same
            if (mapS[charS] != mapT[charT]) return false;
            
            // Map characters to index+1 to avoid default 0 confusion
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }
        
        return true;
    }
}

/*
Since s and t are ascii characters, we can use frequency arrays of size 256 instead of using an explicit hash map (which comes with overhead).

For each character in the given strings, map them into a fixed-size array based on ASCII values.
Check if there is a consistent mapping from characters of s to t and t to s.
*/

/*
Time Complexity: O(n), where n is the length of the string. We iterate over the string once.
Space Complexity: O(1). The space used by the arrays is constant due to the fixed size (256).
*/
    return true;
}
