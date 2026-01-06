class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        char curr;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                curr = grid[row][col];
                if (curr == '1') {
                    helper(grid, row, col);
                    count++;
                };
            }
        }
        return count;
    }

    private void helper(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length) return;
        if (col < 0 || col >= grid[0].length) return;
        if (grid[row][col] == 'x' || grid[row][col] == '0') return;
        grid[row][col] = 'x';
        // traverse in all direction
        // left
        helper(grid, row, col - 1);
        // right
        helper(grid, row, col + 1);
        // top
        helper(grid, row - 1, col);
        // bottom
        helper(grid, row + 1, col);
    }
}