class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, product = 1;
        for(var i=0; i<nums.length; i++){
            product = product * nums[i];
            res = Math.max(product, res);
            if(product == 0) product = 1;
        }
        product = 1;
        for(var i=nums.length-1; i>=0; i--){
            product = product * nums[i];
            res = Math.max(product, res);
            if(product == 0) product = 1;
        }
        return res;
    }
}
