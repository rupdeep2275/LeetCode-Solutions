class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        var res = new int[queries.length];
        var graph = new ArrayList[n];

        for(var i=0; i<n; i++) graph[i] = new ArrayList<Integer>();
        for(var i=0; i<n-1; i++) graph[i].add(i+1);

        var i = 0;
        for(var road : queries){
            graph[road[0]].add(road[1]);
            res[i++] = bfs(n, graph);
        }

        return res;
    }

    int bfs(int n, ArrayList<Integer>[] graph){
        var visited = new boolean[n];
        var q = new LinkedList<Integer>();

        q.add(0);
        visited[0] = true;

        var level = 0;
        while(!q.isEmpty()){
            var size = q.size();
            while(size-->0){
                var curr = q.poll();
                if(curr == n - 1){
                    return level;
                }
                for(var nei : graph[curr]){
                    if(visited[nei]) continue;
                    q.add(nei);
                    visited[nei] = true;
                }
            }
            level++;
        }
        return -1;
    }
}
