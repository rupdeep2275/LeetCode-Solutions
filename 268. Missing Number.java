//Java:

class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, res = 0;
        for(i=0; i<nums.length; i++){
            res ^= i ^ nums[i];
        }
        return res ^ i;
    }
}

//Python:

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = len(nums)
        for i in range(len(nums)):
            res ^= i ^ nums[i]
        return res
