class State{
     int node;
     int distance;
     State(int node , int distance){
        this.node = node;
        this.distance = distance;
     }
}
class Edge{
     int node;
     int weight;
     Edge(int node , int weight){
        this.node = node;
        this.weight = weight;
     } 
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Edge(v , w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;
        int max = 0; // For finding minimum  distance for reaching at any node ,  so max dist[node] = min
        PriorityQueue<State> minHeap = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        minHeap.offer(new State(k , 0));
        while(!minHeap.isEmpty()){
            State curr = minHeap.poll();
            int node = curr.node;
            int currDist = curr.distance;
           // max = Math.max(max , currDist); 

            if(currDist > dist[node])
               continue;

            for(Edge edg : adj.get(node)){
                int neigh = edg.node;
                int edgeWeight = edg.weight;

                int newDist = dist[node] + edgeWeight;

                if(dist[neigh] > newDist){
                    dist[neigh] = newDist;
                    minHeap.offer(new State(neigh , newDist));
                }
            }   
        }
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max , dist[i]);
        }
        return max;
    }
}