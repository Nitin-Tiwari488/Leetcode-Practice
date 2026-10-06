class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        
        while(!set.contains(n)){
           set.add(n);
           int res = 0;
    
         while(n>0){
          
            int digit = n%10;
            n = n/10;
            res += digit*digit;       
        }  
          n = res;
          if(n==1){
            return true;
          }
        }
        return false;
    }
}