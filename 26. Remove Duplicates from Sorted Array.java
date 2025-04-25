class Solution {
    public int removeDuplicates(int[] nums) {
        int x = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]) nums[x++] = nums[i];
        }
        return x;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        var i = 0;
        for(var num : nums){
            if(i == 0 || num > nums[i-1]) nums[i++] = num;
        }
        return i;
    }
}
