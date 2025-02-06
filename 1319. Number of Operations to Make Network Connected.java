class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        DisjointSet ds = new DisjointSet(n + 1);
        int edges = n - 1;
        for(var con : connections){
            if(ds.find(con[0]) != ds.find(con[1])){
                ds.union(con[0], con[1]);
                edges--;
            }
        }
        return edges;
    }
}

class DisjointSet{
    int[] size, parent;
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
