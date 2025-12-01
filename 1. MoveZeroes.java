/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int writePos = 0; // next slot for a non-zero
        for (int readPos = 0; readPos < nums.length; readPos++) {
            if (nums[readPos] != 0) {
                if (readPos != writePos) {
                    int temp = nums[readPos];
                    nums[readPos] = nums[writePos];
                    nums[writePos] = temp;
                }
                writePos++;
            }
        }
    }
}}
}


/*
Maintain two indices:

writePos points to the next position where a non-zero should live.
readPos scans the array left to right.
Whenever nums[readPos] is non-zero, swap it with nums[writePos] (only if readPos != writePos) and advance writePos. This compacts non-zeros in a single pass and leaves zeros behind naturally.

Time Complexity: O(n), as the array is traversed once.
Space Complexity: O(1), no additional data structures are used.
*/
