class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int dist = 0;
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            int pass = nearest(arr1[i] , arr2);
           int diff = Math.abs(arr1[i] - pass);
           if(diff > d)
             dist++;
        }
        return dist;
    }
    static int nearest(int num , int[] arr2){

        int left = 0;
        int right = arr2.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr2[mid]==num){
                return arr2[mid];
            }
            else if(arr2[mid]<num){
               left = mid+1; 
            }
            else
              right = mid-1; 
        }
        if(right < 0) return arr2[left];
        if(left>=arr2.length) return arr2[right];
        if(Math.abs(num - arr2[left]) < Math.abs(num-arr2[right])){
            return arr2[left];
        }
        return arr2[right];
    }
}