class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int x=0;x<n;x++){
            max = Math.max(max , nums[x]);
        }
        int minMove = 0;
        for(int i=0;i<n;i++){
            if(nums[i] < max){
               minMove += (max-nums[i]);
            }
        }
        return minMove;
    }
}