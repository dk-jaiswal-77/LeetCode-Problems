import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if ((first > 0) && nums[first] == nums[first - 1]) continue; // to skip duplicate iterations
            int left = first + 1;
            int right = nums.length - 1;
            int req = 0 - (nums[first]);
            while (left < right) {
                if ((left > first + 1) && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                };
                if ((right < nums.length - 1) && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                };
                int currSum = nums[left] + nums[right];
                if (currSum == req) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                } else if (currSum < req) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}