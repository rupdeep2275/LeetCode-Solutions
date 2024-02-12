class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for(int n : nums){
            if(res == n) count++;
            else count--;
            if(count == 0){
                res = n;
                count = 1;
            }
        }
        return res;
    }
}
