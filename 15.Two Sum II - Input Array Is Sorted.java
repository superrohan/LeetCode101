/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] 
and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<numbers.length; i++){
            int targetNum = target - numbers[i];
            if(map.containsKey(targetNum)){
                
                return new int[] {map.get(targetNum)+1, i+1};
            }
            else{
                map.put(numbers[i], i);
            }
        }

        return null;
    }
}


/*
Since the array is sorted, we can use a two-pointer technique. Start with one pointer at the beginning and the other at the end of the array. Check the sum of the values at these pointers:

If the sum equals the target, return the 1-indexed positions.
If the sum is less than the target, move the left pointer to the right to increase the sum.
If the sum is more than the target, move the right pointer to the left to decrease the sum.
*/
class Solution {
    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // Check if the current sum equals the target
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-indexed positions
            }
            // Move the left pointer right to increase sum
            else if (sum < target) {
                left++;
            }
            // Move the right pointer left to decrease sum
            else {
                right--;
            }
        }
        // It is guaranteed that there will always be one solution, so this line will not be reached
        return new int[]{};
    }
}

/*
Time Complexity:  O(n) - Each element is visited at most once by either of the pointers.
Space Complexity: O(1) - No additional space is used.
*/
