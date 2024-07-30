class Solution {
public:
    int findRow(vector<vector<int>>& matrix, int target) {
        int len = matrix.size();
        int top = 0;
        int bottom = len - 1;
        int mid;
        int row = -1;
        int lastCol = matrix[0].size() - 1;
        while (top <= bottom) {
            mid = top + (bottom - top) / 2;
            int num = matrix[mid][lastCol];
            if (num >= target) {
                row = mid;
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return row;
    }
    int findCol(vector<int> &arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // find possible row
        int row = findRow(matrix, target);
        // cout << "row: " << row << endl;
        if (row < 0) return false;
        int col = findCol(matrix[row], target);
        if (col >= 0) return true;
        return false;
    }
};