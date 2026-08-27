class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nextWarm = new int[n];
        for(int i=0;i<n;i++){
                while(!st.isEmpty() && arr[st.peek()] < arr[i] ){
                    nextWarm[st.peek()] = i - st.peek(); 
                    st.pop();

                }
             st.push(i);
        }

        return nextWarm;
    }
}