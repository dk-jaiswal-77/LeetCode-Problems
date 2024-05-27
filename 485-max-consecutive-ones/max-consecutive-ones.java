class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prevCount = 0;
        int currCount = 0;
        for (int ele: nums) {
            if (ele == 1) {
                currCount++;
            } else if (currCount > prevCount)  {
                prevCount = currCount;
            }
            if (ele != 1) {
                currCount = 0;
            }
        }
        prevCount = currCount > prevCount ? currCount : prevCount;
        return prevCount;
    }
}