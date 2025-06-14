class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[len - i - 1];
            max =Math.max (Math.max(prefix, suffix), max);
        }
        return max;
    }
}