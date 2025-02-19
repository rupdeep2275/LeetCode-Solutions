class Solution {
    public long countBadPairs(int[] nums) {
        int count = 0, n = nums.length;
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            int prevCount = map.getOrDefault(i-nums[i], 0);
            count += prevCount;
            map.put(i-nums[i], prevCount + 1);
        }
        return (n*(n-1))/2 - count;
    }
}
