class Solution {
    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
       
       for(int num : nums){
           totalSum += num;
       }
       Boolean[][] dp = new Boolean[n+1][(totalSum/2)+1];
       if(totalSum % 2==0){
         return solve(0 , nums , totalSum/2 , dp);
       }
       return false;
    }
    static boolean solve(int i , int[] nums , int target , Boolean[][] dp){
        // Base case
        if(target < 0 || i>=nums.length)
           return false;
        if(target==0) return true;

        if(dp[i][target] != null){
            return dp[i][target];
        }

        boolean take = solve(i+1 , nums , target-nums[i] , dp);
        boolean notTake = solve(i+1 , nums , target , dp);

         return dp[i][target] =  take||notTake;      
    }
}