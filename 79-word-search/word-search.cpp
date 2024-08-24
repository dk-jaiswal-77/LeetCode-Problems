class Solution {
public:
    bool isTraversedPos(vector<pair<int, int>>& tPos, int row, int col) {
        for (auto& ele: tPos) {
            if (ele.first == row && ele.second == col) return true;
        }
        return false;
    }
    bool traverse(vector<vector<char>>& board, string& word, int idx, int row, int col, vector<pair<int, int>>& tPos) {
        // all characters in word were found
        if (idx == word.size()) return true;
        tPos.emplace_back(row, col);
        char ch = word[idx];
        bool found = false;
        // left
        if ((col > 0) && (board[row][col-1] == ch) && (!isTraversedPos(tPos, row, col - 1))) {
            if (traverse(board, word, idx + 1, row, col - 1, tPos) == true) {
                found = true;
            };
        }
        // right
        int maxCol = board[0].size() - 1;
        if (!found && (col < maxCol) && (board[row][col + 1] == ch) && (!isTraversedPos(tPos, row, col + 1))) {
            if (traverse(board, word, idx + 1, row, col + 1, tPos) == true) {
                found = true;
            };
        }
        // top
        if (!found && (row > 0) && (board[row - 1][col] == ch) && (!isTraversedPos(tPos, row - 1, col))) {
            if (traverse(board, word, idx + 1, row - 1, col, tPos) == true) {
                found = true;
            };
        }
        // bottom
        int maxRow = board.size() - 1;
        if (!found && (row < maxRow) && (board[row + 1][col] == ch) && (!isTraversedPos(tPos, row+1, col))) {
            if (traverse(board, word, idx + 1, row + 1, col, tPos) == true) {
                found = true;
            };
        }
        tPos.pop_back();
        return found;
    }
    bool exist(vector<vector<char>>& board, string word) {
        vector<pair<int, int>> tPos;
        // find first char
        int rows = board.size();
        int cols = board[0].size();
        char ch = word[0];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == ch) {
                    if (traverse(board, word, 1, row, col, tPos) == true) return true;
                }
            }
        }
        return false;
    }
};