class Solution {
    public int countPrimes(int n) {
        boolean[] mark = new boolean[n];
        Arrays.fill(mark , true);
        if(n<=2) return 0;

        mark[0] = false;
        mark[1] = false;
        
        for(int i=2;i*i<n;i++){
              int j=i*i;
              if(mark[i])
                while(j<n){
                   if(j%i==0){
                    mark[j] = false;
                   }
                    j=j+i;
                }
        }
        int count = 0;
        for(int x=2;x<n;x++){
            if(mark[x]==true)
              count++;
        }
        return count;
    }
}