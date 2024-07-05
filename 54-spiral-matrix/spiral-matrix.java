class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int fr = 0;
        int lr = matrix.length - 1;
        int fc = 0;
        int lc = matrix[0].length - 1;
        while (fr <= lr && fc <= lc) {
            // first row
            for (int col = fc; col <= lc; col++) {
                res.add(matrix[fr][col]);
            }
            fr++;
            // last col
            for (int row = fr; row <= lr; row++) {
                res.add(matrix[row][lc]);
            }
            lc--;
            // last row
            if (lr >= fr) {
                for (int col = lc; col >= fc; col--) {
                    res.add(matrix[lr][col]);
                }
            }
            lr--;
            // first col
            if (fc <= lc) {
                for (int row = lr; row >= fr; row--) {
                    res.add(matrix[row][fc]);
                }
            }
            fc++;
        }
        return res;
    }
}