class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] mat = new int[numRows][];

        for (int r = 0; r < numRows; r++) {
            mat[r] = new int[r + 1];
            Arrays.fill(mat[r], 1);

            for (int c = 1; c < r; c++) {
                mat[r][c] = mat[r - 1][c - 1] + mat[r - 1][c];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] row : mat) {
            List<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            ans.add(list);
        }

        return ans;
    }
}