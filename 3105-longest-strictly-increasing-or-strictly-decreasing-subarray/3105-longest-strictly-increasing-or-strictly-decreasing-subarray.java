class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int incLen = 1;
        int decLen = 1;
        int maxLen = 1;
        for(int i=1;i<n;i++){
            if(nums[i-1] < nums[i]){
                incLen++;
                decLen=1;
            }
            else if(nums[i-1] > nums[i]){
                decLen++;
                incLen=1;
            }
            else{
                incLen=1;
                decLen=1;
            }
            maxLen = Math.max(maxLen , Math.max(incLen , decLen));
        }
        return maxLen;
    }
}