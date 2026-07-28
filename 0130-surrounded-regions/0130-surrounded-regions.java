class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        //Boundary Traversal

         // First Row
        for(int i=0;i<m;i++){
            if(board[0][i] == 'O' && !visited[0][i])
                dfs(board , 0 , i , visited);
        }
     
        // Last Row
        for(int i=0;i<m;i++){
            if(board[n-1][i] == 'O' && !visited[n-1][i])
              dfs(board , n-1 , i , visited);
        }

        // First Col
        for(int j=0;j<n;j++){
            if(board[j][0] == 'O' && !visited[j][0])
              dfs(board , j , 0 , visited);
        }

        // Last Col
        for(int j=0;j<n;j++){
            if(board[j][m-1] == 'O' && !visited[j][m-1])
              dfs(board , j , m-1 , visited);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !visited[i][j])
                   board[i][j] = 'X';
            }
        }

    }
    public static void dfs(char[][] board , int i , int j , boolean[][] visited){

        // Base case
        if(i<0||j<0  ||  i>=board.length || j>=board[0].length || visited[i][j] || board[i][j] !='O')
           return;

        visited[i][j] = true;

        dfs(board , i-1 , j , visited);

        dfs(board , i+1 , j , visited);  

        dfs(board , i , j-1 , visited); 

        dfs(board , i , j+1 , visited);     
    }
}