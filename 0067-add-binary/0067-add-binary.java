class Solution {
    public String addBinary(String a, String b) {
      int n = a.length();
      int m = b.length();
      StringBuilder res = new StringBuilder();
      int carry =0;
      int i=n-1;
      int j=m-1;
      while(i>=0 && j>=0){
          
          int num = (a.charAt(i) -'0') + (b.charAt(j)-'0') + carry;
          res.append(num%2);
          carry = num/2;
          i--;
          j--;

    }
        while(j>=0){
           int b1 = (b.charAt(j)-'0') + carry;
            if(b1 > 1){
                res.append(b1%2);
                carry = b1/2;
            }
            else{
              res.append(b1);
              carry = 0;
            }
            j--;
        }
        while(i>=0){
            int a1 = (a.charAt(i)-'0') + carry;
            if(a1 > 1){
                res.append(a1%2);
                carry = a1/2;
            }
            else{
              res.append(a1);
              carry = 0;
            }
            i--;
        }
        if(carry>0) 
        res.append(carry);
      res.reverse();
    return res.toString();
  }
}