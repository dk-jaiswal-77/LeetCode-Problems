class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] calc = new int[rows][cols];
        return helper(obstacleGrid, 0, 0, calc);
    }
    private int helper(int[][] grid, int row, int col, int[][] calc) {
        // base cases
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == 1) return 0;
        if (row == grid.length - 1 && col == grid[0].length - 1) return 1;
        
        // already calculated, so just use it
        if (calc[row][col] > 0) return calc[row][col];

        // not calculated yet, so calculate and store 
        // case_1: move right
        int right = helper(grid, row, col+1, calc);
        // case_2: move bottom
        int bottom = helper(grid, row + 1, col, calc);
        int total = right + bottom;
        calc[row][col] = total;
        return total;
    }
}