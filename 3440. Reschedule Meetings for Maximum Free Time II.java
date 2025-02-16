class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length + 1;
        int[] gaps = new int[n], preMax = new int[n], sufMax = new int[n];
        gaps[0] = startTime[0];
        for(int i=1; i<n-1; i++){
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[n-1] = eventTime - endTime[n-2];
        preMax[0] = gaps[0];
        for(int i=1; i<n; i++){
            preMax[i] = Math.max(preMax[i-1], gaps[i]);
        }
        sufMax[n-1] = gaps[n-1];
        for(int i=n-2; i>=0; i--){
            sufMax[i] = Math.max(sufMax[i+1], gaps[i]);
        }
        int res = 0;
        for(int i=0; i<n-1; i++){
            int curr = gaps[i] + gaps[i+1];
            int slot = endTime[i] - startTime[i];
            if((i > 0  && preMax[i-1] >= slot) || (i < n-2 &&sufMax[i+2] >= slot)){
                curr += slot;
            }
            res = Math.max(curr, res);
        }
        return res;
    }
}
