class Solution {
    public int maximumCount(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int upperBound = upperBound(nums);
        int lowerBound = lowerBound(nums);
        return Math.max(nums.length - upperBound, lowerBound);
    }
    private int upperBound(int[] nums){
        int lo = 0, hi = nums.length - 1;
        int res = nums.length;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(nums[mid] > 0){
                hi = mid - 1;
                res = mid;
            }
            else lo = mid + 1;
        }
        return res;
    }
    private int lowerBound(int[] nums){
        int lo = 0, hi = nums.length - 1;
        int res = nums.length;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(nums[mid] >= 0){
                res = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return res;
    }
}
