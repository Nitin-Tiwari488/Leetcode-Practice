class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,m,n,grid,visited);
                   count++;
                }
            }
        }
        return count;
    }    
    static void dfs(int i, int j,int m, int n, char[][] grid , boolean[][] visited){

       if(i>=n || j>=m || i<0 || j<0 || grid[i][j]!='1'|| visited[i][j]){
         return;
       }
       visited[i][j] = true;
       dfs(i-1,j,m,n,grid,visited);
       dfs(i+1,j,m,n,grid,visited);  
       dfs(i,j+1,m,n,grid,visited);  
       dfs(i,j-1,m,n,grid,visited);    
    }
}