class Solution {
    int[][] grid;
    int m, n;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid = new int[m][n];
        this.m = m; this.n = n;
        for(var guard : guards) grid[guard[0]][guard[1]] = 2;
        for(var wall : walls) grid[wall[0]][wall[1]] = 2;
        for(var guard : guards) fillGrid(guard[0], guard[1]);
        var count = 0;
        for(var i=0; i<m; i++){
            for(var j=0; j<n; j++){
                if(grid[i][j] == 0) count++;
            }
        }
        return count;
    }
    void fillGrid(int i, int j){
        for(var ii = i+1; ii<m; ii++){
            if(grid[ii][j] == 2) break;
            grid[ii][j] = 1;
        }
        for(var ii=i-1; ii>=0; ii--){
            if(grid[ii][j] == 2) break;
            grid[ii][j] = 1;
        }
        for(var jj=j+1; jj<n; jj++){
            if(grid[i][jj] == 2) break;
            grid[i][jj] = 1;
        }
        for(var jj=j-1; jj>=0; jj--){
            if(grid[i][jj] == 2) break;
            grid[i][jj] = 1;
        }
    }
}
