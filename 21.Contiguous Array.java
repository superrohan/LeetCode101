/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
*/

/*
we can use a prefix sum approach combined with a hash map. The key observation is that if two indices have the same prefix sum, the subarray between them has an equal number of 0s and 1s. 
We maintain a running sum where we treat 0 as -1 and 1 as 1. 
The hash map stores the first occurrence of each running sum. If at some index the running sum is the same as at a previous index, the subarray between those indices is balanced.
*/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);  // base case to handle entire array sum
        int maxLength = 0;
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Update running sum: treat 0 as -1, 1 as 1
            runningSum += nums[i] == 0 ? -1 : 1;
            
            // Check if the running sum has been seen before
            if (sumIndexMap.containsKey(runningSum)) {
                int prevIndex = sumIndexMap.get(runningSum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the first occurrence of this running sum
                sumIndexMap.put(runningSum, i);
            }
        }
        
        return maxLength;
    }
}

/*
Time Complexity: O(n) where (n) is the number of elements in the array. This is due to traversing the array once.
Space Complexity: O(n) where (n) is the number of elements in the array. This is due to the space required for the hash map.
*/
