class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0, n = nums.length;
        for(int i=1; i<n; i++){
            max = Math.max(max, Math.abs(nums[i] - nums[i-1]));
        }
        return Math.max(max, Math.abs(nums[0] - nums[n-1]));
    }
}
