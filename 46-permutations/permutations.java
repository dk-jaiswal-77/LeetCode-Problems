class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int ele: nums) {
                list.add(ele);
            }
            res.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            // swap
            if (i != idx) swap(nums, idx, i);
            // call
            helper(res, nums, idx + 1);
            // reswap
            if (i != idx) swap(nums, idx, i);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}