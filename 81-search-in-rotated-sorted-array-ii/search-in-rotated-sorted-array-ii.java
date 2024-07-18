class Solution {
    public static boolean isSorted(int[] nums, int left, int right) {
        if (nums[left] > nums[right]) return false;
        if (nums[left] < nums[right]) return true;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] != nums[left]) {
                return false;
            }
        }
        return true;
    }
    public static int findPeakEleIdx(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == 0) {
                // mid -> start
                if (nums[mid] > nums[(mid + 1) % nums.length]) return mid;
            } else {
                // mid -> end or between
                if ((nums[mid] >= nums[mid - 1]) && (nums[mid] > nums[(mid + 1) % nums.length])) {
                    return mid;
                }
            }
            // out of left and right part, one is always sorted
            // peak ele always lies in unsorted part
            // checking if left part is sorted
            boolean leftPartSorted = isSorted(nums, left, mid);
            if (leftPartSorted) {
                left = mid + 1;
            } else {
                // right part sorted
                right = mid - 1;
            }
        }
        // all the array elements are same
        return 0;
    }
    public static boolean search(int target, int[] nums, int first, int last) {
        if (first > last) return false;
        int left = first;
        int right = last;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int peakEleIdx = findPeakEleIdx(nums);
        return ((nums[peakEleIdx] == target)
        || search(target, nums, 0, peakEleIdx - 1)
        || search(target, nums, peakEleIdx + 1, nums.length - 1));
    }
}