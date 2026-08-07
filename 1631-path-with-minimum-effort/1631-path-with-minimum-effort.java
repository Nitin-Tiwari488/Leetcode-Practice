class State{
    int currEffort;
    int row;
    int col;
    State(int currEffort , int row , int col){
        this.currEffort = currEffort;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        //Direction Array
        int[] dRow = {-1,1,0,0};
        int[] dCol = {0,0,-1,1};
       int[][] dist = new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           dist[i][j] = Integer.MAX_VALUE; 
        }
       }
       dist[0][0] = 0;
       PriorityQueue<State> minHeap = new PriorityQueue<>((a,b) -> a.currEffort - b.currEffort);
          minHeap.offer(new State(0,0,0));
        
        while(!minHeap.isEmpty()){
             State state = minHeap.poll();
             int currEffort = state.currEffort;
             int  i = state.row;
             int j = state.col;
           
           for(int k=0;k<4;k++){
            int newRow = i+dRow[k];
            int newCol = j+dCol[k];

            // Boundary Check
            if(newRow < 0 || newCol < 0 || newRow >=n || newCol >= m){
                continue;
            }
            // Absolute difference between current and next 
            int diff = Math.abs(heights[i][j] - heights[newRow][newCol]);
            
            // Finding newEffort by comparing with old from dist[newRow][newCol]
            int newEffort = Math.max(currEffort , diff);

            // Relaxation
            if(newEffort < dist[newRow][newCol]){
                dist[newRow][newCol] = newEffort;

                minHeap.offer(new State(newEffort , newRow , newCol));
            }
           }
        }
        return dist[n-1][m-1];
    }
}