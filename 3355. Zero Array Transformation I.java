class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, curr = 0;
        int[] diffArr = new int[n+1];
        for(int[] query : queries){
            diffArr[query[0]] += 1;
            diffArr[query[1] + 1] -= 1;
        }
        for(int i=0; i<n; i++){
            curr += diffArr[i];
            if(curr < nums[i]) return false;
        } 
        return true;
    }
}
