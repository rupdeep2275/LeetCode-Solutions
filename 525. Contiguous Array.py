#Python:

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum, res = 0, 0
        map = defaultdict(int)
        map[0] = -1
        for i in range(len(nums)):
            sum += -1 if nums[i] == 0 else 1
            if sum in map:
                res = max(res, i - map[sum])
            else:
                map[sum] = i
        return res


#Java:

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, res = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(var i=0; i<nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }
            else map.put(sum, i);
        }
        return res;
    }
}
