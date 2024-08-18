class Solution {
    public int[] productExceptSelf(int[] nums) {
        int r = 1, n = nums.length;
        var res = new int[n];
        for(var i=0; i<n; i++){
            res[i] = r;
            r = r * nums[i];
        }
        r = 1;
        for(var i=n-1; i>=0; i--){
            res[i] = res[i] * r;
            r = r * nums[i];
        }
        return res;
    }
}
