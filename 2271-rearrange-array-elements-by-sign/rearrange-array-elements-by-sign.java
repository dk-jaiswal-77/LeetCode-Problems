class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pIdx = 0;
        int nIdx = 1;
        for (int num: nums) {
            if (num > 0) {
                res[pIdx] = num;
                pIdx += 2;
            } else {
                res[nIdx] = num;
                nIdx += 2;
            }
        }
        return res;
    }
}