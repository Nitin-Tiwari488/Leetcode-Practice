class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int peakInd = 0;
        for(int i=1;i<n-1;i++){
            if((arr[i-1] < arr[i]) && (arr[i] > arr[i+1])){
                peakInd = i;
            }
            if((arr[i-1] > arr[i]) && (arr[i] < arr[i+1])){
               return false;
            }    
        }
        if(peakInd == 0){
             return false;
        }
        int left = peakInd - 1;
        int right = peakInd + 1;
        while(left>=0 || right < n){

            if((left >= 0) && (arr[left+1] <= arr[left])){
                return false;
            }
            else if((right < n) && (arr[right] >= arr[right-1])){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}