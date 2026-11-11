class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totalCost = 0;
        if(cost1 + cost2 <= costBoth){
            return 1L*cost1*need1 + 1L*cost2*need2;
        }
        else{
            long mul = Math.min(need1 , need2);
            totalCost = costBoth*mul;
            need1 -= mul;
            need2 -= mul;
            if(need1 > 0){
               long currMin = Math.min(cost1 , costBoth);
               totalCost += currMin * need1;
            }
            else if(need2 > 0){
               long currMin = Math.min(cost2 , costBoth);
               totalCost += currMin * need2;
            }
        }
        return totalCost;
    }
}