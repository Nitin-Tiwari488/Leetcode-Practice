class Solution {
    public int countPrimeSetBits(int left, int right) {
        int set = 0; 
        while(left<=right){
        int count = 0;    
        int num = left;
        while(num > 0){
            if(num % 2 != 0){
                count++;
            }
               num = num/2;
        }
        if(isPrime(count)){
            set++;
        }
        left++;
      }
      return set;
    }
    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=n/2;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}