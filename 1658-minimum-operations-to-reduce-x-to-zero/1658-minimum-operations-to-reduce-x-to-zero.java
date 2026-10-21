class Solution {
    public int minOperations(int[] nums, int x) {
      int n = nums.length;
      int totalSum=0;
      for(int y=0;y<n;y++){
        totalSum+=nums[y];
      }
      int newTarget = totalSum-x;
      if (newTarget < 0) {
            return -1;
        }

        if (newTarget == 0) {
            return n;
        }
      int currSum = 0;
      int j=0;
      int maxLen = -1;
      for(int i=0;i<n;i++){
          currSum += nums[i];
          while(currSum>newTarget && j<=i){
             currSum -= nums[j];
             j++;
          } 
            if(currSum == newTarget){
             int currLen = i-j+1;
             maxLen = Math.max(maxLen , currLen);
            }
      }
      if(maxLen==-1) return -1;
      return n-maxLen;
    }
}