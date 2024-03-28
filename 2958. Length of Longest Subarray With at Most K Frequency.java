//Java:

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int i=0, res = 0;
        for(var j=0; j<nums.length; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.getOrDefault(nums[j], 0) > k){
                map.put(nums[i], map.get(nums[i++]) - 1);
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}


//Python:

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        i, res = 0, 0
        map = defaultdict(int)
        for j in range(len(nums)):
            map[nums[j]] += 1
            while map[nums[j]] > k:
                map[nums[i]] -= 1
                i += 1
            res = max(res, j - i + 1)
        return res
