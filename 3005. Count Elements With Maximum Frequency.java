//Java:

class Solution {
    public int maxFrequencyElements(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int max = 0, res = 0;
        for(var num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            int freq = map.get(num);
            if(freq > max){
                max = freq;
                res = freq;
            }
            else if(freq == max){
                res += freq;
            }
        }
        return res;
    }
}

//Python:

class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq_map = defaultdict(int)
        maxx, res = 0, 0
        for num in nums:
            freq_map[num] += 1
            freq = freq_map[num]
            if freq > maxx:
                maxx = freq
                res = freq
            elif freq == maxx:
                res += freq
        return res
