//Java:

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minB = -1, maxB = -1, badB = -1;
        long res = 0;
        for(var i=0; i<nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK) badB = i;
            else if(nums[i] == minK) minB = i;
            if(nums[i] == maxK) maxB = i;
            res += Math.max(0, Math.min(minB, maxB) - badB);
        }
        return res;
    }
}


//Python:

class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        minB, maxB, badB, res = -1, -1, -1, 0
        for i in range(len(nums)):
            if nums[i] < minK or nums[i] > maxK:
                badB = i
            elif nums[i] == minK:
                minB = i
            if nums[i] == maxK:
                maxB = i
            res += max(0, min(minB, maxB) - badB)
        return res
