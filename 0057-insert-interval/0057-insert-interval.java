class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         int n = intervals.length;
         int[][] ans = new int[n+1][2];
         int first = newInterval[0];
         int second = newInterval[1];
         int i=0;
         int j=0;
         boolean inserted = false;
         while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1]; 

            if(end < first){
                ans[j][0] = start;
                ans[j][1] = end;
                j++;
                i++;
                continue;
            }
            else if(start > second) {
                if(!inserted){
                ans[j][0] = first;
                ans[j][1] = second;
                j++;
                inserted = true;
                }
                while(i<n){
                ans[j][0] = intervals[i][0];
                ans[j][1] = intervals[i][1];
                j++; 
                i++;
                }
            }
            else
            { 
                first = Math.min(first , start);
                second = Math.max(second , end);
                i++;
            }
        }
        if(!inserted){
        ans[j][0] = first;
        ans[j][1] = second;
        j++;
        }
        // Triming ans array size to j
        return Arrays.copyOf(ans , j);
    }
}