class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long maxSum = 0;
        for(int i=0;i<n;i++){
    
            int left = i-1;
            int right = i+1;
            int min = heights[i];
            long sum = heights[i];

            while(left>=0){
                
                if(heights[left] < min){
                    min = heights[left];
                }
                sum += min;
                left--;
            }
             min = heights[i];
             while(right < n){
            
                if(heights[right] < min){
                    min = heights[right];
                }
                sum += min;
                right++;
            }
             maxSum = Math.max(maxSum , sum);
        }
        return maxSum;
    }
}