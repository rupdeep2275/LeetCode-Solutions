class Solution {
    char[][] grid;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n, islands;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for(var i=0; i<m; i++){
            for(var j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    void dfs(int r, int c){
        if(r < 0 || c < 0 || r == m || c == n || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(var d : dirs) dfs(r + d[0], c + d[1]);
    }
}
