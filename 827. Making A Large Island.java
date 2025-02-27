class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        DisjointSet ds = new DisjointSet(m * n + 1);
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int node = n * i + j;
                    for(var d : directions){
                        int x = d[0] + i, y = d[1] + j;
                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                            int neiNode = n * x + y;
                            ds.union(node, neiNode);
                        }
                    }
                } 
            }
        }
        var res = 0;
        var hasZero = false;
        var uniqueRoots = new HashSet<Integer>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    hasZero = true;
                    for(var d : directions){
                        int x = d[0] + i, y = d[1] + j;
                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                            int neiNode = n * x + y;
                            int root = ds.find(neiNode);
                            uniqueRoots.add(root);
                        }
                    }
                    int islandSize = 1;
                    for(int root : uniqueRoots){
                        islandSize += ds.size[root];
                    }
                    res = Math.max(res, islandSize);
                    uniqueRoots.clear();
                }
            }
        }
        if(!hasZero) return m * n;
        return res;
    }
}
class DisjointSet{
    int[] parent, size;
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py) return false;
        if(size[px] < size[py]){
            parent[px] = py;
            size[py] += size[px];
        }
        else{
            parent[py] = px;
            size[px] += size[py];
        }
        return true;
    }
}
