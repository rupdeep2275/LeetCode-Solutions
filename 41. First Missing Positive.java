//Java:

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while(i < n){
            var index = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[index]){
                var temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            else i++;
        }
        for(var j=0; j<n; j++){
            if(nums[j] != j+1) return j+1;
        }
        return n+1;
    }
}

//Python:

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        i, n = 0, len(nums)
        while i < n:
            idx = nums[i] - 1
            if nums[i] >= 0 and nums[i] < n and nums[i] != nums[idx]:
                temp = nums[i]
                nums[i] = nums[idx]
                nums[idx] = temp
            else:
                i += 1
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1
