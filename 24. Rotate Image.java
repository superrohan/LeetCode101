/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
*/

/*
A more efficient solution is to perform the transformation in place by first transposing the matrix (flipping it over its diagonal) and then reversing each row. 
Transposing by itself will reorder the elements diagonally, while reversing will yield the required 90-degree clockwise rotation.

Steps:
Transpose the Matrix: Swap each element (i, j) with the element (j, i).
Reverse Each Row: For each row in the transposed matrix, reverse the elements of the row.
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements on the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                // Swap elements to reverse the row
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}

/*
Time Complexity: O(n^2), where n is the number of rows (or columns) in the matrix.
Space Complexity: O(1), since we are doing the operations in place without using extra space.
*/
