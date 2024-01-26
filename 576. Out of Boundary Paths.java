class Solution {
    int mod = 1_000_000_007;
    int m, n;
    Integer[][][] dp;
    public int findPaths(int m, int n, int maxMove, int row, int col) {
        this.m = m;
        this.n = n;
        dp = new Integer[m][n][maxMove+1];
        return findPath(maxMove, row, col);
    }
    public int findPath(int maxMove, int row, int col){
        if(row == m || col == n || row == -1 || col == -1) return 1;
        if(maxMove == 0) return 0;
        if(dp[row][col][maxMove] != null) return dp[row][col][maxMove];
        int res = 0;
        res += findPath(maxMove - 1, row + 1, col);
        res %= mod;
        res += findPath(maxMove - 1, row - 1, col);
        res %= mod;
        res += findPath(maxMove - 1, row, col + 1);
        res %= mod;
        res += findPath(maxMove - 1, row, col - 1);
        res %= mod;
        return dp[row][col][maxMove] = res;
    }
}
