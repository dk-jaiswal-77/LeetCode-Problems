class Solution {
public:
    bool isValid(int n, int row, int col, vector<vector<char>>& board) {
        // check in row & col
        int len = board.size();
        char num = n + '0'; // Convert int to char
        for (int c = 0; c < len; c++) {
            if (board[row][c] == num || board[c][col] == num) return false;
        }
        // check in 3x3 subgrid
        int rowS = (row / 3) * 3;
        int colS = (col / 3) * 3;
        for (int r = rowS; r < rowS + 3; r++) {
            for (int c = colS; c < colS + 3; c++) {
                if (board[r][c] == num) return false;
            }
        }
        return true;
    }

    bool solveSudoku(vector<vector<char>>& board, int row, int col) {
        if (row == board.size()) return true;  // Solved the puzzle
        if (col == board[0].size()) {
            return solveSudoku(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return solveSudoku(board, row, col + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (isValid(i, row, col, board)) {
                board[row][col] = i + '0';
                if (solveSudoku(board, row, col + 1)) return true;
                board[row][col] = '.';  // Reset if not solved
            }
        }
        return false;
    }

    void solveSudoku(vector<vector<char>>& board) {
        solveSudoku(board, 0, 0);
    }
};
