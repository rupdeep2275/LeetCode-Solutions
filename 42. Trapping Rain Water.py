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
