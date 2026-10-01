class Solution {
    public int romanToInt(String s) {
        int n = s.length();  
        int res = 0;
        HashMap<Character , Integer> mp = new HashMap<>();
        mp.put('I' , 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        
        for(int i=n-1;i>=0;i--){
            
            char ch = s.charAt(i);

            if(i < n-1){
              int prevChar = mp.get(s.charAt(i+1));
            
                if(mp.get(ch) < prevChar){ 
                   res -= mp.get(ch);
                } 
                else{
                res += mp.get(ch);
             }  
            }
            else{
                 res += mp.get(ch);
            }
        }
        return res;
    }
}