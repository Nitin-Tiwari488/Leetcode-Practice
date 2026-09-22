class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        boolean odd = false;
        HashMap<Character , Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch , mp.get(ch)+1);
            }
            else 
             mp.put(ch,1);
        }
         int maxLen = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int val = mp.getOrDefault(ch,0);
            
            if(mp.containsKey(ch) && val % 2 ==0){
                maxLen += val;
            }
            else if(mp.containsKey(ch) && val%2 != 0){
                maxLen += val-1;
                odd = true;
            }
           
            mp.remove(ch);
        }
       if(odd == true){
            maxLen = maxLen+1;
        } 
        return maxLen;
    }
}