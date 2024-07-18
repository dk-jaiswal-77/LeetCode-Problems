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
        return nums.length - 1;
    }
    public int findMin(int[] nums) {
        int peakEleIdx = findPeakEleIdx(nums);
        // peakEleIdx -> first
        // peakEleIdx -> last
        // peakEleIdx -> between
        return nums[(peakEleIdx + 1) % nums.length];
    }
}