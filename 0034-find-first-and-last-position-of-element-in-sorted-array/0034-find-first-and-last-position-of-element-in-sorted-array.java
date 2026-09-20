class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] pos = new int[2];
        Arrays.fill(pos , -1);
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
           int mid = low + (high-low)/2;
           if(nums[mid]==target){
            ans = mid;
            high = mid-1;
           }
           else if(nums[mid] < target){
             low = mid+1;
           }
           else
            high = mid-1;
        }
        pos[0] = ans;
 
       int left = 0;
       int right = n-1;
       while(left<=right){
          int mid = left + (right-left)/2;
           if(nums[mid]==target){
            ans = mid;
            left = mid+1;
           }
           else if(nums[mid] > target){
             right = mid-1;
           }
          else
             left = mid+1;

       }    
       pos[1] = ans;

       return pos;   
    }
}