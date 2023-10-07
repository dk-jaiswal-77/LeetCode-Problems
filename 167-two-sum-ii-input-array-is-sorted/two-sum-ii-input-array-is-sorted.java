class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum;
        int []res = new int[2];
        while (start < end) {
            sum = numbers[start] + numbers[end];
            if (sum == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
                // remove this line later, little more later
                System.out.println("just for testing!");
            }
        }
        return res;
    }
}