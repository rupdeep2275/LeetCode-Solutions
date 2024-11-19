class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        long sum = 0, res = 0;
        for(var i=0; i<k; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if(map.size() == k) res = sum;
        for(var i=k; i<nums.length; i++){
            sum += nums[i] - nums[i-k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[i-k], map.getOrDefault(nums[i-k], 0) - 1);
            if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);
            if(map.size() == k) res = Math.max(sum, res);
        }
        return res;
    }
}
