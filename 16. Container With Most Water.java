/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
*/

/*
we use two pointers, one at the beginning and one at the end of the array. In every step, we calculate the area formed by the lines at these two pointers. 
Then, we move the pointer pointing to the shorter line inward because moving the taller one wouldn't possibly increase the area.

Intuition:
Start with the widest container possible. Move the shorter line inwards step by step.
By closing in the pointers, we seek better maximum areas because even though the width reduces, we might have taller lines.
*/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // Calculate area with current left and right pointer
            int area = Math.min(height[left], height[right]) * (right - left);
            // Update maxArea if current area is larger
            maxArea = Math.max(maxArea, area);

            // Move pointers inward from shorter height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

/*
Time Complexity: O(n) since we go through the list at most twice in a single pass.
Space Complexity: O(1) as no additional space is used apart from some variables for storage.
*/
