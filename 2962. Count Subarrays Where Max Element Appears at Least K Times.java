//Java:

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0, i = 0, n = nums.length, count = 0;
        long res = 0;
        for(var num : nums){
            max = Math.max(num, max);
        }
        for(var j=0; j<n; j++){
            count += nums[j] == max ? 1 : 0;
            while(count >= k){
                res += n - j;
                if(nums[i++] == max) count--;
            } 
        }
        return res;
    }
}

//Python:

class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        maxx, i, n, count, res = 0, 0, len(nums), 0, 0
        for num in nums:
            maxx = max(num, maxx)
        for j in range(n):
            count += 1 if nums[j] == maxx else 0
            while count >= k:
                res += n - j
                if nums[i] == maxx:
                    count -= 1
                i += 1
        return res
