class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int num:nums){
            if(seen.contains(num)){
              continue;
            }
            seen.add(num);

            minHeap.offer(num);
           
           if(minHeap.size() > 3)
              minHeap.poll();
        }
        int max = 0;
        if(minHeap.size() < 3){
            for(int val : minHeap){
               max = Math.max(max , val);
            }
            return max;
        }
         return minHeap.peek();
    }
   
}