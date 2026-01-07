class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // calc left max
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > max) max = height[i];
            leftMax[i] = max;
        }
        // calc right max
        max = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (height[j] > max) max = height[j];
            rightMax[j] = max;
        }

        int sum = 0;
        for (int k = 0; k < n; k++) {
            sum += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return sum;
    }
}