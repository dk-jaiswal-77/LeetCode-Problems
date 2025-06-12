class Solution {
    public static void merge(int[] nums, int left, int mid, int right) {
        List<Integer> res = new ArrayList<>();
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                res.add(nums[p1]);
                p1++;
            } else {
                res.add(nums[p2]);
                p2++;
            }
        }
        while (p1 <= mid) {
            res.add(nums[p1]);
            p1++;
        }
        while (p2 <= right) {
            res.add(nums[p2]);
            p2++;
        }
        int idx = left;
        for (Integer num: res) {
            nums[idx] = num;
            idx++;
        }
    }

    public static int countReversePairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int rStart = mid + 1;
        int curr = rStart;
        int i = left;
        while (i <= mid) {
            while (curr <= right) {
                if (nums[i] > (2L * nums[curr])) {
                    curr++;
                } else {
                    count += (curr - rStart);
                    break;
                }
            }
            if (curr > right) {
                count += (curr - rStart);
            }
            i++;
        }
        return count;
    }

    public static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = 0;
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countReversePairs(nums, left, mid, right);
        merge(nums, left, mid, right);
        return count;
    }
    
    public int reversePairs(int[] nums) {
        int len = nums.length;
        return mergeSort(nums, 0, len - 1);
    }
}
