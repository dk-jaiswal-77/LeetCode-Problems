class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = 0;
        int count = 1;
        for (int curr = 1; curr < nums.length; curr++) {
            if (nums[curr] != nums[prev]) {
                prev++;
                nums[prev] = nums[curr];
                count++;
            }
        }
        return count;
    }
}