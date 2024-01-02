#Python:

class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        freq = [0] * (len(nums) + 1)
        res = []
        for num in nums:
            if freq[num] >= len(res):
                res.append([])
            res[freq[num]].append(num)
            freq[num] += 1
        return res

#Java:

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length+1];
        List<List<Integer>> res = new ArrayList<>();
        for(int num : nums){
            if(freq[num] >= res.size()) res.add(new ArrayList<>());
            res.get(freq[num]).add(num);
            freq[num]++;
        }
        return res;
    }
}
