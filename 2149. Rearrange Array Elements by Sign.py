#Python:

class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        i, j = 0, 1
        res = [0] * len(nums)
        for num in nums:
            if num > 0:
                res[i] = num
                i += 2
            else:
                res[j] = num
                j += 2
        return res

#Java:

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0, j = 1;
        int[] res = new int[nums.length];
        for(int num : nums){
            if(num >= 0){
                res[i] = num;
                i += 2;
            }
            else{
                res[j] = num;
                j += 2;
            }
        }
        return res;
    }
}
