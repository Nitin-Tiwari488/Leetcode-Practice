class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nextSmall = new int[n];
        int[] prevSmall = new int[n];
        Arrays.fill(nextSmall , n);
        Arrays.fill(prevSmall , -1);
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
            }
             if(!st.isEmpty())
                nextSmall[i] = st.peek();
            st.push(i);
          }
          st.clear();
        // For previous smaller element
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                st.pop();
            }
            if(!st.isEmpty())
               prevSmall[i] = st.peek();
            st.push(i);
        }
        // Calculating area of rectangle and identifying  correct width
        int maxArea = 0;
        for(int i=0;i<n;i++){
         int height = heights[i];
         int width = nextSmall[i] - prevSmall[i] -1;
         maxArea = Math.max(maxArea , height * width);
        }
        return maxArea;     
    }
}