class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        minHeap.offer(1L);
        set.add(1L);
        long current = 1L;
        for(int i=0;i<n;i++){
             current = minHeap.poll();
            long[] factor = {2,3,5};
            for(long f : factor){
                long agla = current*f;
                if(set.add(agla)){
                    minHeap.offer(agla);
                }
            }
        }
        return (int)current;
    }
}