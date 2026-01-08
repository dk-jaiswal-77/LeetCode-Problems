class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num: nums) set.add(num);
        
        int max = 0;
        int currMax;
        int curr;
        for (int num: set) {
            // curr ele is not start of seq
            if (set.contains(num - 1)) continue;
            // current ele is start of seq
            // calculate seq length starting from curr ele
            currMax = 1;
            curr = num + 1;
            while (set.contains(curr)) {
                currMax++;
                curr++;
            }
            max = Math.max(currMax, max);
        }
        return max;
    }
}