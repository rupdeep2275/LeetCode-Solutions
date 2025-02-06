class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length, res = 0;
        DisjointSet ds = new DisjointSet(n+1);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    if(ds.union(i, j)) res++;
                }
            }
        }
        return res;
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
