class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int x=1;x<n;x++){
            leftMax[x] = Math.max(height[x] , leftMax[x-1]);
        }
        for(int y=n-2;y>=0;y--){
            rightMax[y] = Math.max(height[y] , rightMax[y+1]);
        }
        for(int i=0;i<n;i++){
            
            ans +=  Math.min(leftMax[i] , rightMax[i]) - height[i];
        }
        return ans;
    }
}