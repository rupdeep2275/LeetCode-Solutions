#Python:

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n, r = len(nums), 1
        res = [0] * n
        for i in range(n):
            res[i] = r
            r = r * nums[i]
        r = 1
        for i in range(n-1, -1, -1):
            res[i] = r * res[i]
            r = r * nums[i]
        return res

#Java:

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, r = 1;
        int[] res = new int[n];
        for(var i=0; i<n; i++){
            res[i] = r;
            r *= nums[i];
        }
        r = 1;
        for(var i=n-1; i>=0; i--){
            res[i] = r * res[i];
            r *= nums[i];
        }
        return res;
    }
}
