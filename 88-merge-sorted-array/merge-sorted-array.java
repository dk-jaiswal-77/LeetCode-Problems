class Solution {
    public void swap(int [] nums1, int a, int [] nums2, int b) {
        int temp = nums1[a];
        nums1[a] = nums2[b];
        nums2[b] = temp;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = 0;
        int len = nums1.length;
        while (p1 >= 0 && p2 < n) {
            if (nums1[p1] > nums2[p2]) {
                swap(nums1, p1, nums2, p2);
                p1--;
                p2++;
            } else break;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        if (len > m) {
            int idx = m;
            for (int i = 0; i < n; i++) {
                nums1[idx] = nums2[i];
                idx++;
            }
        }
    }
}