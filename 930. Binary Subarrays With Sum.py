#Python:

class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        sum, res, freq = 0, 0, [0] * (len(nums) + 1)
        freq[0] = 1
        for num in nums:
            sum += num
            if sum >= goal:
                res += freq[sum - goal]
            freq[sum] += 1
        return res

#Java:

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, res = 0, freq[] = new int[nums.length+1];
        freq[0] = 1;
        for(var num : nums){
            sum += num;
            if(sum >= goal){
                res += freq[sum-goal];
            }
            freq[sum]++;
        }
        return res;
    }
}
