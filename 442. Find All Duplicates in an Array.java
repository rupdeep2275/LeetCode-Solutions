//Java:

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0, n = nums.length;
        while(i < n){
            var correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                var temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }     
            else i++;
        }
        List<Integer> res = new ArrayList<>();
        for(var idx=0; idx<n; idx++){
            if(nums[idx] != idx + 1) res.add(nums[idx]);
        }
        return res; 
    }
}

//Python:

class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        i, n = 0, len(nums)
        while i < n:
            crctIdx = nums[i] - 1
            if nums[i] != nums[crctIdx]:
                temp = nums[i]
                nums[i] = nums[crctIdx]
                nums[crctIdx] = temp
            else:
                i += 1
        res = []
        for i in range(n):
            if nums[i] != i + 1:
                res.append(nums[i])
        return res
