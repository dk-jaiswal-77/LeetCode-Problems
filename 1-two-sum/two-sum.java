class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int more = target - nums[i];
            if (mpp.containsKey(more)) {
                res[0] = i;
                res[1] = mpp.get(more);
                return res;
            }
            mpp.put(nums[i], i);
        }
        return res;
    }
}