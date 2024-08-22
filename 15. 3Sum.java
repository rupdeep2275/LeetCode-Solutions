class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        var n = nums.length;
        for(var i=0; i<n-2; i++){
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int lo = i + 1, hi = n - 1, target = -nums[i];
            while(lo < hi){
                if(nums[lo] + nums[hi] < target) lo++;
                else if(nums[lo] + nums[hi] > target) hi--;
                else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return res;
    }
}
