class Edge{
    int node;
    int price;
    Edge(int node , int price){
        this.node = node;
        this.price = price;
    }
}
class Pair{
    int node;
    int cost;
    int stops;
    Pair(int node , int cost , int stops){
        this.node = node;
        this.cost = cost;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edg : flights){
            int u = edg[0];
            int v= edg[1];
            int price = edg[2];

            adj.get(u).add(new Edge(v,price));
        }
        int[][] cost = new int[k+2][n]; 
        for(int i=0;i<k+2;i++){
            Arrays.fill(cost[i] , Integer.MAX_VALUE);
        }
        cost[0][src]=0;
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.cost , b.cost));
          minHeap.offer(new Pair(src,0,0));

        while(!minHeap.isEmpty()){
            Pair curr = minHeap.poll();
            int node = curr.node;
            int currCost = curr.cost;
            int stops = curr.stops;

           if(stops > k+1) continue; 
           // If destinations reached
           if(node == dst) return currCost;

            for(Edge edge : adj.get(node)){

                 int neigh = edge.node;
                 int edgePrice = edge.price; 

                int newCost = edgePrice + currCost;
                int newStops = stops + 1;

                if(newStops <= k+1 &&newCost < cost[newStops][neigh]){
                    cost[newStops][neigh] = newCost;
                    minHeap.offer(new Pair(neigh , newCost , newStops));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<k+2;i++){
            ans = Math.min(ans , cost[i][dst]);
        }
        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}