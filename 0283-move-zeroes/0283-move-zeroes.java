class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j=0;j<n;j++){
            if(nums[j] != 0){
              swap(nums,i,j);
               i++;
            }

        }
    }
    public void swap(int[] nums ,int x , int y){
        int temp =  nums[x];
           nums[x] = nums[y];
           nums[y] = temp;
    }
}