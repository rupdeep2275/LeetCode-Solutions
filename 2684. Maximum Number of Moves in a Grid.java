class Solution {
    Integer[][] dp;
    int m, n;
    int[][] grid;
    public int maxMoves(int[][] grid) {
        m = grid.length; n = grid[0].length;
        this.grid = grid;
        dp = new Integer[m][n];
        var res = 0;
        for(var i=0; i<m; i++){
            res = Math.max(memoSolve(i, 0), res);
        }
        return res;
    }
    int memoSolve(int i, int j){
        if(dp[i][j] != null) return dp[i][j];
        var res = 0;
        if(i-1>=0 && j+1<n && grid[i-1][j+1] > grid[i][j]) res = 1 + memoSolve(i-1, j+1);
        if(j+1<n && grid[i][j+1] > grid[i][j]) res = Math.max(res, 1 + memoSolve(i, j+1));
        if(i+1<m && j+1<n && grid[i+1][j+1] > grid[i][j]) res = Math.max(res, 1 + memoSolve(i+1, j+1));
        return dp[i][j] = res;
    }
}

//video explanation: https://youtu.be/iJim5dFAoE8
