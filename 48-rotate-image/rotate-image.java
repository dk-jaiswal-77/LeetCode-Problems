class Solution {
    public static void transpose(int[][] arr) {
        int n = arr.length;
        int temp;
        for (int row = 0; row < n; row++) {
            for(int col = row + 1; col < n; col++) {
                temp = arr[row][col];
                arr[row][col] = arr[col][row];
                arr[col][row] = temp;
            }
        }
    }
    public static void reverse(int[][] arr) {
        int n = arr.length;
        for (int row = 0; row < n; row++) {
            // reverse each row
            // two pointer
            int left = 0;
            int right = n - 1;
            int temp;
            while (left < right) {
                temp = arr[row][left];
                arr[row][left] = arr[row][right];
                arr[row][right] = temp;
                left++;
                right--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}