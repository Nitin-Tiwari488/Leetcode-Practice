class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ref = new int[n][n];
        for(int[] row : ref){
            Arrays.fill(row , 0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ref[i][j] = matrix[n-1-j][i];
            }
        }
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                matrix[x][y] = ref[x][y];
            }
        }
    }
}