class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        
        int num = nums[0];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
           if(mp.containsKey(nums[i])){
             mp.put(nums[i] , mp.get(nums[i])+1);
           }
           else
             mp.put(nums[i],1);
        }
        int currCount = 0;
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                if(currCount < mp.get(nums[i])){
                    currCount = mp.get(nums[i]);
                    num = nums[i];
                }
            }
            mp.remove(nums[i]);
        }
        return num;
    }
}