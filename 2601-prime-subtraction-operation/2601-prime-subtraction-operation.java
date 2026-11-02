class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int x : nums){
            max = Math.max(max,x);
        }
        boolean[] mark = new boolean[max+1];
        Arrays.fill(mark , true);
        mark[0] = false;
        mark[1] = false;
        for(int p=2;p*p<=max;p++){
            if(mark[p]){
                int q = p*p;
                while(q <= max){
                    mark[q] = false;
                    q = q+p;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList<>();
        for(int r=0;r<=max;r++){
            if(mark[r] == true){
                prime.add(r);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i] >= nums[i+1]){
                boolean found = false;
                for(int x=0;x<prime.size();x++){
                    if(nums[i] > prime.get(x) && nums[i] - prime.get(x) < nums[i+1]){
                        nums[i] = nums[i] - prime.get(x);
                        found = true;
                        break;
                    }
                }
                if(!found) return false;
            }
        }
        return true;
    }
    static boolean isPrime(int num){
        if(num==0 || num==1) return false;
        for(int i=2;i*i<=num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}