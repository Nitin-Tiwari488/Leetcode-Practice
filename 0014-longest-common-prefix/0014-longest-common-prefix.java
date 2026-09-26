class Solution {
    public String longestCommonPrefix(String[] s) {
         
        
      //  char[] ch = s[].toCharArray();
        int n = s.length;
        Arrays.sort(s);
        String s1 = s[0];
        String s2 = s[n-1];
        StringBuilder res = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();
        int i=0;
        while(i < n1 && i<n2){
            if(s1.charAt(i) == s2.charAt(i)){
                res.append(s1.charAt(i));
                i++;
            }
            else if(s1.charAt(i)!=s2.charAt(i)){
               break;
            }
        }
        return res.toString(); 
    }
}