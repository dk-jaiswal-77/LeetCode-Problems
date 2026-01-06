class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        char ch;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ch = board[r][c];
                if (ch == '.') continue;
                if (!isValid(board, r, c, rows, cols, boxes)) return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, HashSet<Character>[] rows, HashSet<Character>[] cols, HashSet<Character>[] boxes) {
        char ch = board[row][col];
        if (!rows[row].add(ch)) return false;
        if (!cols[col].add(ch)) return false;
        int b = (row / 3) * 3 + (col / 3);
        if (!boxes[b].add(ch)) return false;
        return true;
    }
}