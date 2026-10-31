class Solution {
    public boolean isPowerOfTwo(int n) {
        long sum = 2;
        if(n==2 || n==1) return true;
        while(n > sum){
            sum *= 2;
            if(sum==n){
                return true;
            }
        }
        return false;
    }
}