class Solution {
public:
    bool isPosValid(vector<int>& qPos, int row, int col) {
        if (row == 0) return true;
        for (int qRow = 0; qRow < row; qRow++) {
            int qCol = qPos[qRow];
            // row & col
            if (qRow == row || qCol == col) return false;
            // diagonals -> (++), (--), (+-) & (-+)
            int rowDiff = qRow > row ? qRow - row : row - qRow;
            int colDiff = qCol > col ? qCol - col : col - qCol;
            if (rowDiff == colDiff) return false;
        }
        return true;
    }
    string createStringWithQueen(int len, int pos) {
        string str = "";
        for (int i = 0; i < len; i++) {
            if (i == pos) {
                str.push_back('Q');
            } else {
                str.push_back('.');
            }
        }
        return str;
    }
    void nQueens(vector<vector<string>>& res, vector<string>& temp, vector<int>& qPos, int n, int currRow) {
        // base case
        if (currRow == n) {
            res.push_back(temp);
            return;
        }
        string str;
        for (int col = 0; col < n; col++) {
            if (isPosValid(qPos, currRow, col)) {
                qPos[currRow] = col;
                str = createStringWithQueen(n, col);
                temp.push_back(str);
                nQueens(res, temp, qPos, n, currRow + 1);
                temp.pop_back();
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<string> temp;
        vector<int> qPos(n, 0);
        nQueens(res, temp, qPos, n, 0);
        return res;
    }
};