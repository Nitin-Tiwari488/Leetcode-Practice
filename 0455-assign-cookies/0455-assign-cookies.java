class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        
        int i=0;
        int j=0;
        Arrays.sort(s);
        Arrays.sort(g);

        while(i<n && j<m){

            if(g[i]<=s[j]){
            
               j++;
               i++;
            }
            else
             j++;
        }
        return i;
    }
}