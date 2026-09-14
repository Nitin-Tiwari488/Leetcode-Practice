class Solution {
    public boolean isAnagram(String s, String t) {
       int n = s.length();
       int m = t.length();
       char[] chs = s.toCharArray();
       if(n!=m)
        return false;

       HashMap<Character , Integer> mp = new HashMap<>();
       int[] freq = new int[26];
       for(char c : chs){
          if(mp.containsKey(c)){
             mp.put(c,mp.get(c)+1);
          }
          else
          mp.put(c , 1);
       }
       for(int i=0;i<m;i++){
        char ch = t.charAt(i);
        freq[ch-'a']++;
       }
       for(int j=0;j<26;j++){
         char ch = (char)('a'+j);
        if(freq[j] != mp.getOrDefault(ch , 0)){
            return false;
         }
       }
       return true;
    }
}