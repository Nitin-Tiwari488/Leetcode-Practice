class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        boolean[][] visited = new boolean[n][m];
        
        // First Row
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && !visited[0][j])
              dfs(grid , 0 , j , visited);
        }
        // Last Row
        for(int j=0;j<m;j++){
            if(grid[n-1][j]==1 && !visited[n-1][j])
              dfs(grid , n-1 , j , visited);
        }
        //First Col
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && !visited[i][0])
              dfs(grid , i , 0 , visited);
        }
        // Last Col
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1 && !visited[i][m-1])
              dfs(grid , i , m-1 , visited);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
      
            
        return count;
    }
    
    public static void dfs(int[][] grid , int i, int j ,boolean[][] visited){
          
          // Base Case
          if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]!=1)
            return;
          
          visited[i][j] = true;

          dfs(grid , i-1 ,j , visited); 
          dfs(grid , i+1 ,j , visited); 
          dfs(grid , i ,j-1 , visited); 
          dfs(grid , i ,j+1 , visited); 

    }
}