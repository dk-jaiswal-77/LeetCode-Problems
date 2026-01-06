class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowsMax = new int[n];
        int[] colsMax = new int[n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // update rows max
                if (grid[r][c] > rowsMax[r]) rowsMax[r] = grid[r][c];
                // update cols max
                if (grid[r][c] > colsMax[c]) colsMax[c] = grid[r][c];
            }
        }

        int sum = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                sum += Math.min(rowsMax[r], colsMax[c]) - grid[r][c];
            }
        }
        return sum;
    }
}