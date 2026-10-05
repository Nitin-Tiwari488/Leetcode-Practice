class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int[][] ans = new int[n+1][2];
        int j=0;
        int i=0;
        while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];
        
            while(i<n-1 && intervals[i+1][0] <= end){
                end = Math.max(end , intervals[i+1][1]);
                i++;
            }
                ans[j][0] = start;
                ans[j][1] = end;
                j++;
                i++;
        }
        return Arrays.copyOf(ans , j);
    }
}