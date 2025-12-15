/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/

/*
By using two pointers that traverse the height array from both ends. It uses variables to store current left and right max heights, allowing us to calculate the trapped water more efficiently without additional space.

Initialize two pointers, left at the start and right at the end of the array.
Maintain two variables leftMax and rightMax for the maximum heights encountered from the left and right, respectively.
Move the pointers towards each other, updating trapped water based on which of leftMax and rightMax is smaller.
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;
        
        while (left < right) {
            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                // If left is smaller, check against leftMax
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                // If right is smaller, check against rightMax
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        
        return trappedWater;
    }
}


/*
Time Complexity: O(n) as we traverse the height array only once with the two pointers.
Space Complexity: O(1) because we use only constant extra space.
*/
