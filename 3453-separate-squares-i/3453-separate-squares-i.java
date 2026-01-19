class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0.0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for(int[] sq : squares){
            int x = sq[0], y=sq[1], l=sq[2];
            totalArea += (double) l*l;
            low = Math.min(low, y);
            high = Math.max(high, y+l);
        }
        double target = totalArea / 2.0;
        double left = low , right=high;
        while(right - left > 1e-6){
            double mid = (left + right) / 2;
            double below = areaBelow(mid, squares);
            if(below >= target){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return left;
    }
    // Helper function
    private double areaBelow(double c, int[][] squares) {
        double area = 0.0;
        for(int[] sq : squares){
            int y = sq[1], l=sq[2];
            if(c<=y){
                continue;
            }
            else if(c >= y+l){
                area += (double) l*l;
            }
            else{
                area += (c-y) * l;
            }
        }
       return area;
    }
}