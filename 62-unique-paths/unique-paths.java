class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) dp[i] = 1;
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[col] += dp[col + 1];
            }
        }
        return dp[0];
    }
}