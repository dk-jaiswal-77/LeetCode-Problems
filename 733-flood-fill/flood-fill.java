class Solution {
    int rows[] = {0, 0, -1, 1};
    int cols[] = {-1, 1, 0, 0};

    public void traverse(int[][] matrix, int r, int c, int color, int initC) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] != initC) return;
        matrix[r][c] = color;
        int row, col;

        for (int i = 0; i < 4; i++) {
            row = r + rows[i];
            col = c + cols[i];
            traverse(matrix, row, col, color, initC);
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int visited[][] = new int[image.length][image[0].length];
        if (image[sr][sc] == color) return image;
        traverse(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}