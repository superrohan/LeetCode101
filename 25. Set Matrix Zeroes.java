/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/

/*
we can use two separate arrays. One for rows and another for columns that need to be zeroed. This makes the algorithm more space efficient.

Steps:
Use two arrays zeroRows and zeroCols to track rows and columns with zeroes.
First, iterate through the original matrix to fill zeroRows and zeroCols.
Iterate again through the matrix, using zeroRows and zeroCols to set the appropriate rows and columns to zero.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // First pass to record zero rows and columns
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    zeroRows[r] = true;
                    zeroCols[c] = true;
                }
            }
        }

        // Second pass to set zero rows and columns
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (zeroRows[r] || zeroCols[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}

/*
Time Complexity: O(m * n), where m is the number of rows and n is the number of columns.
Space Complexity: O(m + n) for the row and column arrays.
*/
