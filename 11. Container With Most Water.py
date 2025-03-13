#Python:

class Solution:
    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height) - 1
        max_water = 0
        while i < j:
            water = min(height[i], height[j]) * (j - i)
            max_water = max(water, max_water)
            if height[j] > height[i]:
                i += 1
            else:
                j -= 1
        return max_water 

#Java:

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }
}
