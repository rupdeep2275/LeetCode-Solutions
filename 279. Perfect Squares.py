#Python:

class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[1] = 1
        for i in range(2, n+1):
            minn = float('inf')
            j = 1
            while j*j <= i:
                rem = i - j * j
                minn = min(minn, dp[rem])
                j += 1
            dp[i] = minn + 1
        return dp[n]

#Java:

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                int rem = i - j * j;
                min = Math.min(min, dp[rem]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
