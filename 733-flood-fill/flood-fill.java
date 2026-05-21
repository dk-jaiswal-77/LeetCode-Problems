class Solution {
    int rows[] = {0, 0, -1, 1};
    int cols[] = {-1, 1, 0, 0};

    public void traverse(int[][] matrix, int r, int c, int color, int initC, int[][] visited) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || visited[r][c] == 1 || matrix[r][c] != initC) return;
        matrix[r][c] = color;
        visited[r][c] = 1;
        int row, col;

        for (int i = 0; i < 4; i++) {
            row = r + rows[i];
            col = c + cols[i];
            traverse(matrix, row, col, color, initC, visited);
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int visited[][] = new int[image.length][image[0].length];
        traverse(image, sr, sc, color, image[sr][sc], visited);
        return image;
    }
}