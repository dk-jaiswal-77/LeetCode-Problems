class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int idx = left;
        int curr;
        while (idx <= right) {
            curr = nums[idx];
            // case_1: curr ele is 0
            if (curr == 0) {
                if (idx != left) swap(nums, left, idx);
                left++;
                idx++;
                continue;
            }
            // case_2: curr ele is 2
            if (curr == 2) {
                if (idx != right) swap(nums, idx, right);
                right--;
                continue;
            }
            // case_3: curr ele is 1
            idx++;
        }
    }
    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}