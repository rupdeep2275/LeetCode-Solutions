class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length, res = 0, j=0, sum = 0;
        var gaps = new int[n+1];
        if(startTime[0] > 0) gaps[0] = startTime[0];
        for(int i=1; i<n; i++){
            int gap = startTime[i] - endTime[i-1];
            gaps[i] = gap;
        }
        if(endTime[n-1] < eventTime) gaps[n] = eventTime - endTime[n-1];
        for(int i=0; i<=k && i<n+1; i++){
            sum += gaps[i];
            res = Math.max(res, sum);
        }
        for(int i=k+1; i<n+1; i++){
            sum += gaps[i] - gaps[j++];
            res = Math.max(res, sum);
        }
        return res;
    }
}
