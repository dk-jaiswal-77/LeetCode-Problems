class Solution {
    public static int firstOccurenceIdx(int[] arr, int t) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int idx = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == t) {
                idx = mid;
                right = mid - 1;
            } else if (arr[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }
    public static int lastOccurenceIdx(int[] arr, int t) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int idx = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == t) {
                idx = mid;
                left = mid + 1;
            } else if (arr[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int foidx = firstOccurenceIdx(nums, target);
        if (foidx >= 0) {
            res[0] = foidx;
            res[1] = lastOccurenceIdx(nums, target);
        }
        return res;
    }
}