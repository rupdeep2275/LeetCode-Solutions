class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int oranges = 0, time = 0, m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) oranges++;
                else if(grid[i][j] == 2) q.add(new Pair(i, j));
            }
        }
        if(oranges == 0) return 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            if(oranges == 0) return time;
            int size = q.size();
            while(size-->0){
                Pair p = q.poll();
                for(int[] d : dirs){
                    int x = d[0] + p.x;
                    int y = d[1] + p.y;
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.add(new Pair(x, y));
                        oranges--;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
