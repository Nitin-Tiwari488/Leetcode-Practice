class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int num = 0;
        int count = 0;
        for(int i=0;i<n;i++){
           if(count==0){
             num = nums[i];
             count=1;
           }
           else if(num==nums[i]){
             count++;
           }
           else
             count--;
        }
        return num;
    }
}