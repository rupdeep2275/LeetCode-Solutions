class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int height = Math.abs(sy - fy);
        int width = Math.abs(sx - fx);

        if(height == 0 && width == 0 && t == 1) return false;

        return t >= Math.max(height, width);
    }
}