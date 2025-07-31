class Solution {
public:
    // Helper function using memoization
    int helper(vector<int>& nums, vector<int>& dp, int idx) {
        
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int robThisHouse = nums[idx] + helper(nums, dp, idx - 2);
        
        int skipThisHouse = helper(nums, dp, idx - 1);
        
        dp[idx] = max(robThisHouse, skipThisHouse);

        return dp[idx];
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
    
        vector<int> dp(n, -1);
    
        return helper(nums, dp, n - 1);
    }
};

