class Solution {
    public void moveZeroes(int[] nums) {
        int prev = 0;
        for (int curr = 1; curr < nums.length; curr++) {
            if (nums[curr] == 0 && nums[prev] != 0) {
                prev = curr;
            }
            if (nums[curr] != 0 && nums[prev] == 0) {
                nums[prev] = nums[curr];
                nums[curr] = 0;
                prev++;
            }
        }
    }
}