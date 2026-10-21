class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        HashMap<Character,Integer> mp1 = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for(int x=0;x<n;x++){
            char ch1 = t.charAt(x);
            if(mp1.containsKey(ch1)){
                mp1.put(ch1 , mp1.get(ch1)+1);
            }
            else
             mp1.put(ch1 , 1);
        }

        if(m<n){
            return "";
        }
        HashMap<Character,Integer> mp2 = new HashMap<>();
        
        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right=0;right<m;right++){
            char ch = s.charAt(right);
            mp2.put(ch , mp2.getOrDefault(ch,0) + 1);
            while(isValid(mp1 , mp2)){
                char lCh = s.charAt(left);
                int currLen = right-left+1;
                if(currLen < minLen){
                    minLen = currLen;
                    start = left;
                }
                mp2.put(lCh , mp2.get(lCh)-1);
                left++; 
           }
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start , start+minLen);
    }
    static boolean isValid(HashMap<Character,Integer> mp1 , HashMap<Character,Integer> mp2){
        for(char key : mp1.keySet()){
            if(!mp2.containsKey(key)) return false;
            if(mp1.get(key) > mp2.get(key)) return false;
        }
        return true;
    }
}