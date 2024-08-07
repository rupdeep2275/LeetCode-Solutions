class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(var n : nums){
            if(n == 0) red++;
            else if(n == 1) white++;
            else blue++;
        }
        for(var i=0; i<nums.length; i++){
            if(i < red) nums[i] = 0;
            else if(i < red + white) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
