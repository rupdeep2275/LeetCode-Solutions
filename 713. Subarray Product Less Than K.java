//Java:

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int i = 0, j = 0, product = 1, res = 0;
        while(j < nums.length){
            product *= nums[j++];
            while(product >= k){
                product /= nums[i++];
            }
            res += j - i;
        }
        return res;
    }
}

//Python:

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        i, j, product, res = 0, 0, 1, 0
        while j < len(nums):
            product *= nums[j]
            while product >= k:
                product /= nums[i]
                i += 1
            res += j - i + 1
            j += 1
        return res
