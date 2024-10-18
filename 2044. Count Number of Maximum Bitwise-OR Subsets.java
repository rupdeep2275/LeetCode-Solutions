class Solution {
    int[] nums;
    int targetOr;
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        var maxOr = 0;
        for(var num : nums) maxOr |= num;
        targetOr = maxOr;
        return countMaxOrSubsets(0, 0);
    }
    int countMaxOrSubsets(int i, int currOr){
        if(i == nums.length) return currOr == targetOr ? 1 : 0;
        var countWithoutCurr = countMaxOrSubsets(i+1, currOr);
        var countWithCurr = countMaxOrSubsets(i+1, currOr | nums[i]);
        return countWithoutCurr + countWithCurr;
    }
}

//Explanation: https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/solutions/5933291/easy-recursive-solution/
