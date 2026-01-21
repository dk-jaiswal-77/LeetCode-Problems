class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return climb(0, n, dp);
    }
    private int climb(int curr, int n, int[] dp) {
        if (curr == n) return 1;
        if (curr > n) return 0;
        // already calculated
        if (dp[curr] != -1) return dp[curr];
        // not yet calculated
        // so calculate and store it in dp
        dp[curr] = climb(curr+1, n, dp) + climb(curr+2, n, dp);
        return dp[curr];
    }
}