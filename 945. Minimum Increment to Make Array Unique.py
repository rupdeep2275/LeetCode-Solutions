#Python:

class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        nums.sort()
        steps, need = 0, 0
        for num in nums:
            steps += max(need - num, 0)
            need = max(num, need) + 1
        return steps

#Java:

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int steps = 0, need = 0;
        for(var num : nums){
            steps += Math.max(need - num, 0);
            need = Math.max(need, num) + 1;
        }
        return steps;
    }
}
