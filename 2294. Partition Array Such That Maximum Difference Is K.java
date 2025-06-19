class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
            if(max - min > k){
                res++;
                max = num;
                min = num;
            }
        }
        return res;
    }
}
