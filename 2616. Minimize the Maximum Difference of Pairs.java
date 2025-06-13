class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, lo = 0, hi = nums[n - 1] - nums[0];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(countValidPairs(nums, mid) >= p) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    private int countValidPairs(int[] nums, int threshold) {
        int count = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] <= threshold){
                count++;
                i++;
            }
        }
        return count;
    }
}
