class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n =nums2.length;
        int m = nums1.length;
        int[] ans = new int[m];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
         mp.put(nums2[n-1] , -1);
        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && nums2[i] > st.peek()){
                st.pop();
             }
            if(!st.isEmpty())
               mp.put(nums2[i] , st.peek());

            else 
             {
                mp.put(nums2[i] , -1);
             }
             st.push(nums2[i]);
        }
        for(int x=0;x<m;x++){
            if(mp.containsKey(nums1[x])){
                ans[x] = mp.get(nums1[x]);
            }
        }
        return ans;
    }
}