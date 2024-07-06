class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> mappings = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            count += mappings.getOrDefault(sum - k, 0);
            if (mappings.containsKey(sum)) {
                mappings.put(sum, mappings.get(sum) + 1);
            } else {
                mappings.put(sum, 1);
            }
        }
        return count;
    }
}