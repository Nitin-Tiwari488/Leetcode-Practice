class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer , Integer> mp = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
           if(mp.containsKey(arr[i])){
              continue;
           }
            mp.put(arr[i],i);
        }
        for(int j=0;j<n;j++){
            if(mp.containsKey(target-arr[j]) && mp.get(target-arr[j]) < j){
                ans[0] = mp.get(target-arr[j])+1;
                ans[1] = j+1;
            }
        }
        return ans;
    }
}