class Solution {
    int[] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int ldsSize = getLdsSize(nums);
        return constructLds(nums, ldsSize);
    }
    private int getLdsSize(int[] nums){
        Arrays.sort(nums);
        dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int lds = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                lds = Math.max(dp[i], lds);
            }
        }
        return lds;
    }
    private List<Integer> constructLds(int[] nums, int ldsSize){
        var res = new LinkedList<Integer>();
        int prev = -1;
        for(int i=nums.length-1; i>=0; i--){
            if(dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)){
                res.addFirst(nums[i]);
                prev = nums[i];
                ldsSize--;
            }
        }
        return res;
    }
}
