class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNode = new ArrayList<>();
        int idx =0 ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     adj.add(new ArrayList<>());
        // }

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i=0;i<n;i++){

            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        
        } 
        for(int u=0;u<n;u++){
            for(int v : graph[u]){

            adj.get(u).add(v);   
            rev.get(v).add(u);
            }
        }    

        int[] outdegree = new int[n];

        for(int u=0;u<n;u++){
            for(int v : adj.get(u)){
                outdegree[u]++;
            }
        }
       
    
        Queue<Integer> q = new LinkedList<>();
        for(int x=0;x<n;x++){
            if(outdegree[x]==0)
            q.offer(x);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            safeNode.add(curr);
            for(int neigh : rev.get(curr)){

                outdegree[neigh]--;
                
                if(outdegree[neigh]==0)
                  q.offer(neigh);
            }
        }
        Collections.sort(safeNode);
        return safeNode;
    }
}