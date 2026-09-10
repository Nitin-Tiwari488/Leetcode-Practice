class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int i=0 , j=0;
       int[] ans = new int[n+m];
       int k=0;
       while(i<m && j<n){

         if(nums1[i] < nums2[j]){
            ans[k++] = nums1[i];
            i++;
         }
         else
         
           ans[k++] = nums2[j++];
           
         
       }
       while(i<m){
        ans[k++] = nums1[i++];

       }
       while(j<n){
        ans[k++] = nums2[j++];
       }
       int p=0;
       for(int x=0;x<ans.length;x++){
            nums1[p++] = ans[x];
       }
       for(int y=0;y<nums1.length;y++){
        System.out.print(nums1[y] + " ");
       }
    }
}