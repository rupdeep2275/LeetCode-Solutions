#Python:

class Solution:
    def trap(self, height: List[int]) -> int:
        lo, hi, l_max, r_max, water = 0, len(height) - 1 , 0, 0, 0
        while lo < hi:
            if height[lo] < height[hi]:
                l_max = max(l_max, height[lo])
                water += l_max - height[lo]
                lo += 1
            else:
                r_max = max(r_max, height[hi])
                water += r_max - height[hi]
                hi -= 1
        return water

#intuitive:

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
        int lo = 0, hi = height.length - 1, water = 0, leftMax = 0, rightMax = 0;
        while(lo < hi){
            if(height[lo] < height[hi]){
                leftMax = Math.max(leftMax, height[lo]);
                water += leftMax - height[lo++];
            }
            else{
                rightMax = Math.max(rightMax, height[hi]);
                water += rightMax - height[hi--];
            }
        }
        return water;
    }
}

#intuitive:

class Solution {
    public int trap(int[] height) {
        int n = height.length, maxTillNow = height[0], res = 0;;
        int[] maxL = new int[n], maxR = new int[n];
        for(var i=1; i<n; i++){
            maxL[i] = maxTillNow;
            maxTillNow = Math.max(maxTillNow, height[i]);
        }
        maxTillNow = height[n-1];
        for(var i=n-2; i>=0; i--){
            maxR[i] = maxTillNow;
            maxTillNow = Math.max(maxTillNow, height[i]);
        }
        for(var i=1; i<n-1; i++){
            res += Math.max(0, Math.min(maxL[i], maxR[i]) - height[i]);
        }
        return res;
    }
}
