class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        for (; right < n; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}