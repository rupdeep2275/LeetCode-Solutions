#Python:

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        freq = Counter(nums)
        res = 0
        for x in freq.values():
            if x == 1:
                return -1
            res += ceil(x/3)
        return res

#Java:

class Solution {
    public int minOperations(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(int x : freq.values()){
            if(x == 1) return -1;
            res += Math.ceil((double)x/3);
        }
        return res;
    }
}
