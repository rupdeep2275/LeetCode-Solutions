class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        for i in range(1, len(nums)):
            if (nums[i] - nums[i-1]) % 2 == 0:
                return False
        return True


class Solution {
    public boolean isArraySpecial(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if((nums[i] - nums[i-1]) % 2 == 0) return false;
        }
        return true;
    }
}
