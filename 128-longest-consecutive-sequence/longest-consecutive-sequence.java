import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }
        int maxCount = 0;
        for (Integer num: numSet) {
            int count;
            int prevMax;
            if (!numSet.contains(num - 1)) {
                prevMax = num;
                count = 1;
                while(numSet.contains(++prevMax)) {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }
}