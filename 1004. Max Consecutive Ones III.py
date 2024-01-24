#Python:

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        i, max_len, zero_count = 0, 0, 0
        for j in range(0, len(nums)):
            if nums[j] == 0:
                zero_count += 1
            while zero_count > k:
                if nums[i] == 0:
                    zero_count -= 1
                i += 1
            max_len = max(max_len, j - i + 1)
        return max_len

#Java:

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, max = 0, zeroCount = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] == 0) zeroCount++;
            while(zeroCount > k){
                if(nums[i] == 0){
                    zeroCount--;
                }
                i++;
            }
            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}
