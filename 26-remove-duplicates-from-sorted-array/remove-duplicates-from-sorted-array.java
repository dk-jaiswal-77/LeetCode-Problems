class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right;
        for (right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                if (left != right) {
                    nums[left] = nums[right];
                }
            }
        }
        return left + 1;
    }
}