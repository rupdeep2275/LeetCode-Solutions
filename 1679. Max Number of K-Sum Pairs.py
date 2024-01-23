#Python:

class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        lo, hi, res = 0, len(nums) - 1, 0
        while lo < hi and lo < len(nums) and hi >= 0:
            summ = nums[lo] + nums[hi]
            if summ == k:
                lo += 1
                hi -= 1
                res += 1
            elif summ < k:
                lo += 1
            else:
                hi -= 1
        return res

#Java:

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int res  = 0;
        while(lo < hi && lo < nums.length && hi >= 0){
            int sum = nums[lo] + nums[hi];
            if(sum == k){
                res++;
                lo++;
                hi--;
            }
            else if(sum < k){
                lo++;
            }
            else hi--;
        }
        return res;
    }
}
