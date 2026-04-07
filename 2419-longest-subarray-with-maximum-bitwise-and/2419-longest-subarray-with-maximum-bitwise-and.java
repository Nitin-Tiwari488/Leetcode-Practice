class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int result = 0;
        int streak = 0;
        for(int i:nums){
            if(i>maxVal){
                maxVal = i;
                result =0;
                streak=0;
            }
            if(maxVal==i){
                streak++;
            }
            else{
                streak = 0;
            }
              //result = Math.max(result , streak);
        
            result = Math.max(result , streak);
        }
        return result;
    }
}