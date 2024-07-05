class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int eleCount = matrix.length * matrix[0].length;
        int fr = 0;
        int lr = matrix.length - 1;
        int fc = 0;
        int lc = matrix[0].length - 1;
        int count = 0;
        while (fr <= lr && fc <= lc) {
            // first row
            for (int col = fc; col <= lc; col++) {
                res.add(matrix[fr][col]);
                count++;
            }
            fr++;
            if (count >= eleCount) break;
            // last col
            for (int row = fr; row <= lr; row++) {
                res.add(matrix[row][lc]);
                count++;
            }
            lc--;
            if (count >= eleCount) break;
            // last row
            for (int col = lc; col >= fc; col--) {
                res.add(matrix[lr][col]);
                count++;
            }
            lr--;
            if (count >= eleCount) break;
            // first col
            for (int row = lr; row >= fr; row--) {
                res.add(matrix[row][fc]);
                count++;
            }
            fc++;
        }
        return res;
    }
}