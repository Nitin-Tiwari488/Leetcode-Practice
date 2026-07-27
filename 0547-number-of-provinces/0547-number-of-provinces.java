class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count =0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
    
                if(!visited[i])
                  count++;
                   dfs(isConnected , i , visited);
        }
        return count;
    }
    public static void dfs(int[][] isConnected ,int i , boolean[] visited){
        visited[i] = true;
        for(int neigh=0; neigh<isConnected.length; neigh++){
           if(isConnected[i][neigh] == 1 && !visited[neigh]){
            dfs(isConnected , neigh , visited);
           }
        }
    }
}