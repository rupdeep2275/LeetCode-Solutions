class Solution {
    public int minCapability(int[] nums, int k) {
        int lo = 1, hi = Arrays.stream(nums).max().getAsInt();
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            if(kTheftsPossible(nums, k, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    boolean kTheftsPossible(int[] nums, int k, int capability){
        int thefts = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= capability){
                thefts++;
                i++;
            }
        }
        return thefts >= k;
    }
}
