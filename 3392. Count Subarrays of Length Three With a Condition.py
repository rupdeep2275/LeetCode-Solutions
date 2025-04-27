class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        count = 0
        for i in range(0, len(nums)-2):
            if 2 * (nums[i] + nums[i+2]) == nums[i+1]:
                count += 1
        return count 


class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length-2; i++){
            if(2 *(nums[i] + nums[i+2]) == nums[i+1]) count++;
        }
        return count;
    }
}
