/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
*/

/*
We can leverage a HashSet to eliminate duplicates and achieve O(n) complexity for finding consecutive sequences by only attempting to build from numbers that are not part of any smaller sequence.

Add numbers to HashSet: This allows constant-time lookups.
Iterate over the Set:
For each number, check if it is the start of a sequence.
Calculate the length of that sequence by incrementing and checking the presence of subsequent numbers.
Track the maximum sequence length.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if num is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Increment currentNum to count the length of sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}

/*
Time Complexity: O(n), where n is the length of the array due to one pass through the elements and constant time lookups.
Space Complexity: O(n), because of the space used by the HashSet.
*/
