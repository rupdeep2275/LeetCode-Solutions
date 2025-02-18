class Solution {
    Integer[][][] dp;
    int[][] coins;
    int m, n;
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        this.coins = coins;
        dp = new Integer[m][n][3];
        return dp(0, 0 , 2);
    }
    int dp(int i, int j, int k){
        if(i == m || j == n) return Integer.MIN_VALUE;
        if(i == m-1 && j == n-1){
            if(coins[i][j] >= 0) return coins[i][j];
            else return k > 0 ? 0 : coins[i][j];
        }
        if(dp[i][j][k] != null) return dp[i][j][k];
        int res = coins[i][j] + Math.max(dp(i+1, j, k), dp(i, j+1, k));
        if(k > 0) res = Math.max(Math.max(dp(i+1, j, k-1), dp(i, j+1, k-1)), res);
        return dp[i][j][k] = res;
    }
}
