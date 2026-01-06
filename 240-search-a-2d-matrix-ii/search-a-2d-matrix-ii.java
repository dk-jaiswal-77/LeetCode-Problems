class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int currRow = 0;
        int currCol = cols - 1;
        int curr;
        while (currRow < rows && currCol >= 0) {
            curr = matrix[currRow][currCol];
            if (curr == target) return true;
            if (curr < target) currRow++;
            else currCol--;
        }
        return false;
    }
}