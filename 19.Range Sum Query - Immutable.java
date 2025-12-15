/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
*/

/*
A more optimal approach is to preprocess the input array to create a prefix sum array.

Intuition:
The prefix sum at each index i stores the cumulative sum of the array from 0 to i.
For a query to get the sum from index i to j, we can use the formula: [ \text{sumRange}(i, j) = \text{prefixSum}[j] - \text{prefixSum}[i-1] ]
This reduces the time complexity of each query to O(1).
Steps:
Initialize a prefix sum array with an extra zero at the start for ease of calculation.
For each element in the input array, calculate the cumulative sum and store it in the prefix sum array.
When a query is made, use the formula above to get the sum in constant time.
*/

class NumArray {
    private int[] prefixSums;

    public NumArray(int[] nums) {
        // Initialize the prefix sums array
        prefixSums = new int[nums.length + 1];
        
        // Build the prefix sum array
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        // Use prefix sums to calculate the range sum in O(1) time
        return prefixSums[j + 1] - prefixSums[i];
    }
}

/*
Time Complexity: O(n) for preprocessing where n is the number of elements in the input array. O(1) for each sum range query.
Space Complexity: O(n) due to the prefix sum array.
*/
