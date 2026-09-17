class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       HashSet<Character> set = new HashSet<>();
       int maxLen = 0;
       int j=0;
       for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        if(set.contains(ch)){
            while(set.contains(ch)){
                set.remove(s.charAt(j));
                j++;
            }
        }
        set.add(ch);
        int len = i-j+1;
        maxLen = Math.max(maxLen , len);
       }
       return maxLen;
    }
}