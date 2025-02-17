class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        for(var edge : edges){
            if(!ds.union(edge[0], edge[1])) return edge;
        }
        return new int[]{};
    }
}
class DisjointSet{
    int[] size, parent;
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
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
