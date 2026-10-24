class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
               set.add(candyType[i]);
        }
        return (set.size()>(n/2)? n/2 : set.size());
    }
}