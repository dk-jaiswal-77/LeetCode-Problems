import java.lang.Integer;
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int ele: nums) {
            currSum += ele;
            if (currSum > sum) {
                sum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return sum;
    }
}