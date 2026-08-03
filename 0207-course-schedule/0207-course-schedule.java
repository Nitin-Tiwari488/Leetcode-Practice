class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int processed = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){

           int course = pre[0];
           int prerequisite = pre[1];

           adj.get(prerequisite).add(course);
    }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        
        for(int u=0;u<numCourses;u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
         for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
               q.offer(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            processed++;

            for(int neigh : adj.get(curr)){

                indegree[neigh]--;

                if(indegree[neigh]==0)
                   q.offer(neigh);
            }
           
        }
        return (processed==numCourses? true : false);
    }
}