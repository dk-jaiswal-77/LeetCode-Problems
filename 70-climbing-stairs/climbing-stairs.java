class Solution {
    public int climbStairs(int n) {
        int prev1, prev2;
        prev1 = 1;
        prev2 = 0;

        int curr = n- 1;
        int temp;
        while (curr >= 0) {
            temp = prev1 + prev2;
            prev2 = prev1;
            prev1 = temp;
            curr--;
        }
        return prev1;
    }
}