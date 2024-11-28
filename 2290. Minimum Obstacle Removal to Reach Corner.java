class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    public int minimumObstacles(int[][] grid) {
        m = grid.length; n = grid[0].length;
        var minObstacles = new Integer[m][n];
        var q = new ArrayDeque<Trio>();
        q.add(new Trio(0, 0, 0));
        while(!q.isEmpty()){
            var curr = q.poll();
            int obstacles = curr.x, row = curr.y, col = curr.z;
            for(var d : dirs){
                int newRow = d[0] + row, newCol = d[1] + col;
                if(isValid(newRow, newCol) && minObstacles[newRow][newCol] == null){
                    if(grid[newRow][newCol] == 1){
                        minObstacles[newRow][newCol] = obstacles + 1;
                        q.add(new Trio(obstacles + 1, newRow, newCol));
                    }
                    else{
                        minObstacles[newRow][newCol] = obstacles;
                        q.addFirst(new Trio(obstacles, newRow, newCol));
                    }
                }
            }
        }
        return minObstacles[m-1][n-1];
    }
    boolean isValid(int row, int col){
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
class Trio{
    int x, y, z;
    Trio(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
