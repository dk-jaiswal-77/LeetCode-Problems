class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = -1;
            }
        }
        return helper(0, 0, arr);
    }

    public int helper(int row, int col, int[][] dp) {
        if (row >= dp.length || col >= dp[0].length) return 0;
        if (row == dp.length - 1 && col == dp[0].length - 1) return 1;
        // already calculated, use it
        if (dp[row][col] != -1) return dp[row][col];
        // not calculated yet, calculate, store & return
        dp[row][col] = helper(row, col + 1, dp) + helper(row + 1, col, dp);
        return dp[row][col];
    }
}