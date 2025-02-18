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
        int n = height.length, max = height[0], res = 0;
        int[] lMax = new int[n], rMax = new int[n];
        for(int i=1; i<n; i++){
            lMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[n-1];
        for(int i=n-2; i>=0; i--){
            rMax[i] = max;
            max = Math.max(max, height[i]);
        }
        for(int i=1; i<n-1; i++){
            int water = Math.max(0, Math.min(lMax[i], rMax[i]) - height[i]);
            res += water;
        }
        return res;
    }
}
