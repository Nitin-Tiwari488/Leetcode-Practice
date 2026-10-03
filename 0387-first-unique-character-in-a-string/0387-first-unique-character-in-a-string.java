class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int ans = -1;
        HashMap<Character , Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch , mp.get(ch)+1);
            }
            else
             {
                mp.put(ch , 1);
             }
        }
        for(int i=0;i<n;i++){
            char ch1 = s.charAt(i);
            if(mp.get(ch1)==1){
               ans = i;
               break;
            }   
        }
        return ans;
    }
}