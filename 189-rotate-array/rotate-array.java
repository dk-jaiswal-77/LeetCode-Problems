class Solution {
    public static void reverse(int[] nums, int left, int right) {
        int temp;
        while(left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = (k % len);
        if (k == 0 || len == 1) return;
        Solution.reverse(nums, 0, len - k - 1);
        Solution.reverse(nums, len - k, len - 1);
        Solution.reverse(nums, 0, len - 1);
    }
}