class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];
        for(int i=1; i<n; i++){
            if(nums[i] <= nums[i-1]) prefix[i] = prefix[i-1] + 1;
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i] <= nums[i+1]) suffix[i] = suffix[i+1] + 1;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=k; i<n-k; i++){
            if(prefix[i-1] >= (k-1) && suffix[i+1] >= (k-1)) res.add(i);
        }
        return res;
    }
}
