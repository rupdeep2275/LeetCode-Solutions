class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        res, c1, c2 = 1, 1, 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                c1 += 1
            else:
                res = max(res, c1)
                c1 = 1
            if nums[i] < nums[i-1]:
                c2 += 1
            else:
                res = max(res, c2)
                c2 = 1
        res = max(res, c1, c2)
        return res
            
        
