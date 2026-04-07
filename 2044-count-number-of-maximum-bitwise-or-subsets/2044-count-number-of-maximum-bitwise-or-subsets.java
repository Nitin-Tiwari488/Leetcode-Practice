class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // 1. Find MaxOR
        // 2. Find subsets having ORvalue == maxOR
        int maxOr = 0;
        for(int num:nums){
            maxOr |= num;
        }
        int currOr = 0;
        return countSubsets(0,currOr,nums,maxOr);
    }
    int countSubsets(int i,int currOr,int[] nums, int maxOr){
        if(i==nums.length){
        if(currOr == maxOr)
          return 1;
        return 0;
    }
        int take = countSubsets(i+1, currOr|nums[i],nums,maxOr);
        int nTake = countSubsets(i+1,currOr,nums,maxOr);
        return take+nTake;
    }
}