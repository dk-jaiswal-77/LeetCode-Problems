class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int curr = 1;
        while (topRow <= bottomRow && leftCol <= rightCol) {
            // top row
            for (int col = leftCol; col <= rightCol; col++) {
                res[topRow][col] = curr;
                curr++;
            }
            topRow++;
            // right col
            for (int row = topRow; row <= bottomRow; row++) {
                res[row][rightCol] = curr;
                curr++;
            }
            rightCol--;
            // bottom row
            for (int col = rightCol; col >= leftCol; col--) {
                res[bottomRow][col] = curr;
                curr++;
            }
            bottomRow--;
            // left col 
            for (int row = bottomRow; row >= topRow; row--) {
                res[row][leftCol] = curr;
                curr++;
            }
            leftCol++;
        }
        return res;
    }
}