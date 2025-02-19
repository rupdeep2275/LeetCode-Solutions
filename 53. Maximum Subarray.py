class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res, sum = float('-inf'), 0
        for num in nums:
            sum += num
            res = max(sum, res)
            if sum < 0:
                sum = 0
        return res

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE;
        for(var n : nums){
            sum += n;
            res = Math.max(sum, res);
            if(sum < 0) sum = 0;
        }
        return res;
    }
}
