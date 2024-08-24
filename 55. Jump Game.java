class Solution {
    public boolean canJump(int[] nums) {
        var reach = 0;
        for(var i=0; i<nums.length; i++){
            if(i > reach) return false;
            reach = Math.max(reach, i+nums[i]);
        }
        return true;
    }
}
