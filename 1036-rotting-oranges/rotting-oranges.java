class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // enqueing the initial rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(r);
                    queue.offer(c);
                }
            }
        }

        int rChange[] = {0, 0, -1, 1};
        int cChange[] = {-1, 1, 0, 0};

        int count = 0;
        int size;
        int row, col, adjR, adjC;
        // if (queue.isEmpty()) return -1;
        while (!queue.isEmpty()) {
            size = queue.size() / 2;
            for (int curr = 0; curr < size; curr++) {
                row = queue.poll();
                col = queue.poll();

                // exploring all 4 directions of current orange
                for (int i = 0; i < 4; i++) {
                    adjR = row + rChange[i];
                    adjC = col + cChange[i];
                    if (adjR >= 0 && adjC >= 0 && adjR < rows && adjC < cols && grid[adjR][adjC] == 1) {
                        grid[adjR][adjC] = 2;
                        queue.offer(adjR);
                        queue.offer(adjC);
                    }
                }
            }
            if (!queue.isEmpty()) count++;
        }

        // traverse through grid to find if all the fresh oranges are rotten
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                if (grid[a][b] == 1) return -1;
            }
        }
        return count;
    }
}