/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]
*/

/*
The first idea is to use the property that if two strings are anagrams of each other, their sorted form will be the same. By sorting each string and using it as a key,
we can group the words that are anagrams together.

Iterate over the list of strings.
Sort each string and use it as a key in a hashmap where the value will be a list of strings.
Finally, return all the values of the hashmap that represent grouped anagrams.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store the list of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String word : strs) {
            // Convert the word to an array of characters
            char[] charArray = word.toCharArray();
            // Sort the array
            Arrays.sort(charArray);
            // Convert back to string
            String sortedWord = new String(charArray);
            
            // If the sorted word is not in the map, add it with an empty list
            if (!anagramMap.containsKey(sortedWord)) {
                anagramMap.put(sortedWord, new ArrayList<>());
            }
            
            // Append the original word to the corresponding list
            anagramMap.get(sortedWord).add(word);
        }
        
        // Return the grouped list of anagrams
        return new ArrayList<>(anagramMap.values());
    }
}

/*
Time Complexity: O(NK log K) where N is the number of strings and K is the maximum length of a string. Sorting each string takes O(K log K).
Space Complexity: O(NK), the space for storing the groups of anagrams.
*/
