class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        boolean inserted = false;
        int[] curr;
        int idx = 0;
        if (intervals[0][0] < newInterval[0]) {
            curr = intervals[0];
            idx++;
        }
        else {
            curr = newInterval;
            inserted = true;
        }

        List<int[]> res = new ArrayList<>();

        while (idx < intervals.length) {
            if (!inserted) {
                if (newInterval[0] <= curr[1]) {
                    curr[1] = Math.max(curr[1], newInterval[1]);
                    inserted = true;
                    continue;
                } else if (newInterval[0] <= intervals[idx][0]) {
                    res.add(curr);
                    curr = newInterval;
                    inserted = true;
                    continue;
                }
            }
            if (intervals[idx][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[idx][1]);
            } else {
                res.add(curr);
                curr = intervals[idx];
            }
            idx++;
        }
        if (inserted) {
            res.add(curr);
        } else {
            if (newInterval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], newInterval[1]);
                res.add(curr);
            } else {
                res.add(curr);
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}