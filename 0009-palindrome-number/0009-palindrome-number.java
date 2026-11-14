class Solution {
    public boolean isPalindrome(int x) {

        if(x<0)
          return false;

       int newNum = 0;
       int n = x;
       while(n>0){
          int currNum = n%10;
          n = n/10;
          newNum = newNum * 10 + currNum;
       }  
       return newNum == x; 
    }
}