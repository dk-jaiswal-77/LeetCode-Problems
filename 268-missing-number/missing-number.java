class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        for (int j = 0; j < n; j++) {
            xor1 ^= nums[j];
        }
        return xor1;
    }
}