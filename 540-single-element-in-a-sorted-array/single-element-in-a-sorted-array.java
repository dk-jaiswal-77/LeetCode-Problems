class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int prevIdx;
        while (left <= right) {
            mid = left + (right - left) / 2;
            prevIdx = mid - 1;
            if (mid == 0) {
                prevIdx = nums.length - 1; // last element
                if (nums[mid] != nums[(mid + 1) % nums.length]) {
                    return nums[mid];
                }
            } else {
                if (nums[mid] != nums[prevIdx] && nums[mid] != nums[(mid + 1) % nums.length]) {
                    return nums[mid];
                }
            }
            // mid is at even position
            if (mid % 2 == 0) {
                if (nums[mid] == nums[prevIdx]) {
                    // single element lies in left part
                    right = mid - 1;
                } else {
                    // single element lies in right part
                    left = mid + 1;
                }
            } else {
                // mid is at odd position
                if (nums[mid] == nums[prevIdx]) {
                    // single element lies in right part
                    left = mid + 1;
                } else {
                    // single element lies in left part
                    right = mid - 1;
                }
            }
        }
        return nums[mid];
    }
}