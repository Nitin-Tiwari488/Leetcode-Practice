class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n-1;i++){ 
            HashSet<Integer> seen = new HashSet<>(); 
            for(int j=i+1;j<n;j++){
                    int need = -(nums[i]+nums[j]);
                    if(seen.contains(need)){
                        List<Integer> res = Arrays.asList(nums[i] , nums[j] , need);
                        Collections.sort(res);
                        set.add(res);
                    }
                    seen.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}