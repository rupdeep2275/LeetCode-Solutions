#Python:

class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        nums.sort()
        res = []
        for i in range(0, len(nums), 3):
            if nums[i+2] - nums[i] > 2:
                return []
            res.append([nums[i], nums[i+1], nums[i+2]])
        return res
        

#Java:

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length/3][3];
        for(int i=2; i<nums.length; i+=3){
            if(nums[i] - nums[i-2] > k) return new int[0][0];
            res[i/3] = new int[]{nums[i-2], nums[i-1], nums[i]};
        }
        return res;
    }
}
