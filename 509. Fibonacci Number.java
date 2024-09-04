class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int prev = 1, prevToPrev = 0, res = 0;
        for(var i=2; i<=n;i++){
            res = prev + prevToPrev;
            prevToPrev = prev;
            prev = res;
        }
        return res;
    }
}
