/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

//Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            else if(num == candidate) {
                count++;
            }
            else {
                count--;
            }
        }
        return candidate;
    }
}

/*
It maintains:

candidate: current guess for the majority
count: confidence in the candidate
As you scan:

If count == 0, adopt the current number as the new candidate.
If the current number equals candidate, increment count; otherwise, decrement it.
If a true majority exists, this process guarantees the final candidate is that majority.
*/


/*
Time Complexity: O(n) since it passes through the array once.
Space Complexity: O(1) since only a few additional variables are used.
*/

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Sorting the Array

/*
If we sort the array, all identical elements naturally group together. Since the majority element appears more than n/2 times, it must occupy the entire middle region of the sorted array.
That means the element at index n/2 will always be the majority element.
*/

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/*
Time Complexity: O(n log n) due to sorting.
Space Complexity: O(1) when using in-place sorting (ignoring input space).
*/
