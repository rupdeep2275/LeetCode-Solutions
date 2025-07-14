class Solution {
    int target = 0, offset = 1000;
    Integer[][] dp;
    int[] nums;
    public int findTargetSumWays(int[] nums, int target) {
        this.dp = new Integer[nums.length][2001];
        this.nums = nums;
        this.target = target;
        return memoSolve(0, 0);
    }
    int memoSolve(int i, int sum){
        if(i == dp.length){
            return sum == target ? 1 : 0;
        }
        if(dp[i][sum + offset] != null) return dp[i][sum + offset];
        int res = memoSolve(i+1, sum + nums[i]) + memoSolve(i+1, sum - nums[i]);
        return dp[i][sum + offset] = res;
    }
}
