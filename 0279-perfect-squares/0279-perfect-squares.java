class Solution {
    public int numSquares(int n) {

        int size = (int) Math.sqrt(n);
       int[] squares = new int[size];

        int[][] memo = new int[size+1][n+1];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }

       for(int i=1;i*i<=n;i++){
        squares[i-1] = i*i;
       }
       return minWay(0,n,squares,memo);
    }
    static int minWay(int i , int n , int[] squares, int[][] memo){
        if(n==0)
         return 0;

        if(i==squares.length) return 1000;

        if(memo[i][n] != -1){
            return memo[i][n];
        }
        int take = 1000; 
        if(squares[i] <= n){   
            take =  1+minWay(i , n-squares[i] , squares,memo);
        }
           int ntake = minWay(i+1,n,squares,memo);
        
          return memo[i][n] = Math.min(take , ntake);
    }
}