class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch=='['|| ch=='{'){
                st.push(ch);
                continue;
            }
            else if(!st.isEmpty()){
                if((ch == ')' && st.peek()=='(')  
                || (ch==']' && st.peek()=='[') 
                || (ch=='}' && st.peek()=='{')){
                  st.pop();
                  continue;
                }
            }
             st.push(ch);
        }
        if(st.isEmpty())
          return true;

        else
         return false;  
    }
}