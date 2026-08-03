class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int idx=0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);

            indegree[course]++;
        }
        
        

        Queue<Integer> q = new LinkedList<>();
        for(int x=0;x<numCourses;x++){
            if(indegree[x]==0)
               q.offer(x);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            res[idx++] = curr;
        

            for(int neigh : adj.get(curr)){
                
                 indegree[neigh]--;

                 if(indegree[neigh]==0)
                   q.offer(neigh);
            }
        }
        return (idx==numCourses? res : new int[0]);
    }
}