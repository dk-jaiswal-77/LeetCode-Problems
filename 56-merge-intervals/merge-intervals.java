class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] curr = intervals[0];
        int[] interval;
        for (int i = 1; i < intervals.length; i++) {
            interval = intervals[i];
            // overlapping
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(interval[1], curr[1]);
            }
            // or not overlapping
            else {
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }
}