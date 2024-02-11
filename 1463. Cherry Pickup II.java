class Solution {
    int[][] grid;
    Integer[][][] dp;
    int m, n;
    public int cherryPickup(int[][] grid) {
        m = grid.length; n = grid[0].length;
        this.grid = grid;
        dp = new Integer[m][n][n];
        return dfs(0, 0, n-1);
    }
    private int dfs(int r, int c1, int c2){
        if(r >= m || c1 < 0 || c1 >= n || c2 < 0 || c2 >= n) return 0;
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];

        int currCheries = 0;
        if(c1 == c2) currCheries = grid[r][c1];
        else currCheries += grid[r][c1] + grid[r][c2];

        int maxCherries = 0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                maxCherries = Math.max(maxCherries, dfs(r+1, c1+i, c2+j));
            }
        }
        return dp[r][c1][c2] = currCheries + maxCherries;
    }
}
