class Solution {
    public int earliestAcq(int[][] logs, int n) {
        DisjointSet ds = new DisjointSet(n);
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int groupSize = n;
        for(int[] log : logs){
            if(ds.union(log[1], log[2])){
                groupSize--;
                if(groupSize == 1) return log[0];
            }
        }
        return -1;
    }
}
class DisjointSet{
    int[] size, parent;
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
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
        if(size[x] < size[y]){
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
