class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // remove out of window element from bottom of queue
            if (!queue.isEmpty() && queue.peekFirst() <= (i - k)) queue.poll();
            // remove all elements lesser or equal to curr element from top of the queue
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            queue.offer(i);
            // choose an element from bottom of the queue (as max element in the current window)
            // if the first window forms at this index or window is already sliding
            if (i >= (k - 1)) {
                res[idx] = nums[queue.peekFirst()];
                idx++;
            }
        }
        return res;
    }
}