class Solution {
    public String largestNumber(int[] nums) {
        if (allZeros(nums)) return "0";
        String[] str = new String[nums.length];
        // convert to array of string
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }
        // sort this array in ascending order
        Arrays.sort(str, (a, b) -> (a+b).compareTo(b+a));
        // concatenate the array elements from last to first
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            res.append(str[i]);
        }
        return res.toString();
    }

    private boolean allZeros(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) return false;
        }
        return true;
    }
}