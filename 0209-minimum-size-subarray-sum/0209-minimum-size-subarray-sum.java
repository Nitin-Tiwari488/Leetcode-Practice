class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j=0;
        int sum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum >= target){
                int currLen = i-j+1;
                if(currLen < minLen){
                    minLen = currLen;
                    start = j;
                }
                sum -= nums[j];
                j++;
            }
        }
        if(minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
}