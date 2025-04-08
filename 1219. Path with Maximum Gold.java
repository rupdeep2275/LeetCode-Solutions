class Solution {
    int[][] grid;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int maxGold = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxGold = Math.max(maxGold, dfs(i, j));
            }
        }
        return maxGold;
    }
    int dfs(int i, int j){
        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) return 0;
        int gold = grid[i][j], max = 0;
        grid[i][j] = 0;
        for(int[] d : dirs){
            max = Math.max(max, dfs(i + d[0], j + d[1]));
        }
        grid[i][j] = gold;
        return max + gold;
    }
}
