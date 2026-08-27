class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

       for(int w : weights){
          low = Math.max(low , w);
          high += w;
       }
       while(low < high){
        
        int mid = low + (high - low) / 2;

        if(canShip(weights , days , mid)){
         
            high = mid;
        }
        else
          low = mid+1;

       }
       return low;
    }
    static boolean canShip(int[] weights , int days , int cap){
       int daysNeed = 1;
       int currLoad = 0;
       for(int w : weights){
          if(currLoad + w > cap){
            daysNeed++;
            currLoad = 0;
          }
          currLoad += w;
       }
       return daysNeed <= days;
    }
}