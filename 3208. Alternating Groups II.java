class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedColors = new int[colors.length + k - 1];
        for(int i=0; i<colors.length; i++){
            extendedColors[i] = colors[i];
        }
        for(int i=0; i<k-1; i++){
            extendedColors[colors.length + i] = colors[i];
        }
        int n = extendedColors.length, res = 0, lo = 0, hi = 1;
        while(hi < n){
            if(extendedColors[hi] != extendedColors[hi - 1]){
                if(hi - lo + 1 == k){
                    res++;
                    lo++;
                }
            }
            else{
                lo = hi;
            }
            hi++;
        }
        return res;
    }
}
