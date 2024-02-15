#Python:

class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        summ, res = nums[0] + nums[1], 0
        for i in range(2, len(nums)):
            if(summ > nums[i]):
                res = max(res, summ + nums[i])
            summ += nums[i]
        return res if res > 0 else -1 

#Java:

class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        summ, res = nums[0] + nums[1], 0
        for i in range(2, len(nums)):
            if(summ > nums[i]):
                res = max(res, summ + nums[i])
            summ += nums[i]
        return res if res > 0 else -1 
