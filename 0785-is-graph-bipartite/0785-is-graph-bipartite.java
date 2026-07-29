class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color , -1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!bfs(graph , i , color))
                  return false;
            }
        }
        return true;
    }
    public static boolean bfs(int[][] graph ,int node , int[] color){
        color[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh : graph[curr]){

                 if(color[neigh]==-1){
                    color[neigh] = 1- color[curr];
                    q.offer(neigh);
                    }   
                    else if(color[neigh] == color[curr])
                      return false;   
            }
        }
        return true;
    }
    
}