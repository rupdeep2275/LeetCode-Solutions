class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        len, res, maxx = 0, 1, 0
        for num in nums:
            maxx = max(maxx, num)
        for num in nums:
            if num == maxx:
                len += 1
            else:
                len = 0
            res = max(len, res)
        return res


class Solution {
    public int longestSubarray(int[] nums) {
        int len = 0, res = 1, max = 0;
        for(var num : nums){
            max = Math.max(num, max);
        }
        for(var i=0; i<nums.length; i++){
            if(nums[i] == max){
                len++;
            }
            else len = 0;
            res = Math.max(res, len);
        }
        return res;
    }
}
