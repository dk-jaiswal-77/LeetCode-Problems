class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        int temp;
        for (; right < nums.length; right++) {
            if (nums[right] != val) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return left;
    }
}