class Solution {
    public int[] countBits(int n) {
        var res = new int[n+1];
        for(int i=1; i<=n; i++){
            if(i%2==0) res[i] = res[i/2];
            else res[i] = res[i-1] + 1;
        }
        return res;
    }
}
