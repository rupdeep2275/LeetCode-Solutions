//Java:

class Solution {
    public int missingNumber(int[] nums) {
        var res = nums.length;
        for(var i=0; i<nums.length; i++){
            res ^= i ^ nums[i];
        }
        return res;
    }
}

//Python:

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = len(nums)
        for i in range(len(nums)):
            res ^= i ^ nums[i]
        return res
