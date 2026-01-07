class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstPos(nums, target);
        if (first < 0) return new int[]{-1, -1};
        int last = lastPos(nums, target);
        return new int[]{first, last};
    }
    private int firstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int idx = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                idx = mid;
                right = mid - 1;
            }
            else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return idx;
    }

    private int lastPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int idx = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                idx = mid;
                left = mid + 1;
            } else if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return idx;
    }
}