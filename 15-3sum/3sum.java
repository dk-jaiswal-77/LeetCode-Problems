class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int target;
        int left, right, sum;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            target = 0 - nums[i];
            left = i + 1;
            right = n - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < n- 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}