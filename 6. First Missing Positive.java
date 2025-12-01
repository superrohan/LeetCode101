/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Add all nums into the HashSet
        for (int num : nums) {
            set.add(num);
        }
        // Check from 1 to infinite for the first missing number
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; // The function should never reach here
    }
}


/*
Intuition:
Rather than checking every number by iterating through the array, we can store all numbers in a HashSet for O(1) look-up time.
Iterate through numbers starting from 1 and check if they are in the HashSet.
Steps:
Insert all numbers into a HashSet.
Start checking integers from 1 onwards.
If any integer is not found in the HashSet, that's the first missing positive number.
*/

/*
Time Complexity: O(n) - Linear time to populate the set and checking numbers
Space Complexity: O(n) - Space used for storing array elements in the HashSet.
*/
