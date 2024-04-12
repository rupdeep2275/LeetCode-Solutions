#Python:

class Solution:
    def trap(self, height: List[int]) -> int:
        n, max_till_now, res = len(height), 0 , 0
        max_l = [0] * n
        max_r = [0] * n
        for i in range(n):
            max_l[i] = max_till_now
            max_till_now = max(max_till_now, height[i])
        max_till_now = 0
        for i in range(n - 1, -1, -1):
            max_r[i] = max_till_now
            max_till_now = max(max_till_now, height[i])
        for i in range(1, n-1):
            water = min(max_l[i], max_r[i]) - height[i]
            if water > 0:
                res += water
        return res

#Java:

class Solution {
    public int trap(int[] height) {
        int n = height.length, maxTillNow = 0, res = 0;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        for(var i=0; i<n; i++){
           maxL[i] = maxTillNow;
           maxTillNow = Math.max(maxTillNow, height[i]);
        }
        maxTillNow = 0;
        for(var i=n-1; i>=0; i--){
            maxR[i] = maxTillNow;
            maxTillNow = Math.max(maxTillNow, height[i]);
        }
        for(int i=1; i<n-1; i++){
            var water = Math.min(maxL[i], maxR[i]) - height[i];
            if(water > 0) res += water;
        }
        return res;
    }
}
