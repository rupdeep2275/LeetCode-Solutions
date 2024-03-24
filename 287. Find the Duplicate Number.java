//Java:

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while(i < n){
            var correctIndex = nums[i] - 1;
            if(nums[correctIndex] != nums[i]){
                var temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else{
                i++;
            }
        }
        for(var index=0; index<n; index++){
            if(nums[index] != index + 1){
                return nums[index];
            }
        }
        return -1;
    }
}

//Python:

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        n, i = len(nums), 0
        while i < n:
            crct_idx = nums[i] - 1
            if nums[crct_idx] != nums[i]:
                temp = nums[i]
                nums[i] = nums[crct_idx]
                nums[crct_idx] = temp
            else:
                i += 1
        for i in range(n):
            if nums[i] != i + 1:
                return nums[i]
        return -1
