class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0;  i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
            if (sum == k) {
                count++;
            }
            int curr = i - 1;
            while (curr >= 0) {
                if (sum - nums[curr] == k) {
                    count++;
                }
                curr--;
            }
        }
        return count;
    }
}