//Java:

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        var dp = new int[n+1];
        dp[1] = 1; dp[2] = 2;
        for(var i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

//Python:

class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        dp = [0] * (n+1)
        dp[1], dp[2] = 1, 2
        for i in range(3, n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]
