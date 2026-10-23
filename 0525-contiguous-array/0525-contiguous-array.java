class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int[] pref = new int[n];

        if(nums[0]==0){
            nums[0] = -1;
        }
        pref[0] = nums[0];
        for(int x=1;x<n;x++){
           if(nums[x]==0){
            nums[x] = -1;
           }
           pref[x] = pref[x-1] + nums[x];
        }
        for(int i=0;i<n;i++){
            if(mp.containsKey(pref[i])){
               int len = i - mp.get(pref[i]);
               maxLen = Math.max(maxLen , len);
            }
            else
            mp.put(pref[i] , i);
        }
        return maxLen;
    }
}