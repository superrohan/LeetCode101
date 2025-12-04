/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If map already has the number and the difference between indices is <= k
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            // Update the latest index of the current number
            map.put(nums[i], i);
        }
        // If no such pair found, return false
        return false;
    }
}


/*
Time Complexity: O(n): We traverse the array once, each operation with HashMap is O(1) on average.
Space Complexity: O(n): In the worst case, all elements might be unique in the array. Hence, the HashMap can store up to n unique elements and their last seen indices.
*/
