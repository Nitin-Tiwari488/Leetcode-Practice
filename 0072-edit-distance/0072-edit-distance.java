class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
          Arrays.fill(row , -1);
        }
        return solve(0,0,word1,word2,dp);
    }
    static int solve(int i , int j, String word1 , String word2 , int[][] dp){
        
        if(i==word1.length())
           return word2.length()-j;
        if(j==word2.length())
          return word1.length() - i;
        
        if(dp[i][j] != -1)
          return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j))
          return dp[i][j] = solve(i+1 , j+1 , word1 , word2 , dp);

        return dp[i][j] = 1 + Math.min(solve(i+1 ,j,word1,word2,dp) , // Delete
                                Math.min(solve(i,j+1,word1,word2,dp) ,  // Insert
                                      solve(i+1,j+1,word1 , word2,dp))); // Replace
    }
}