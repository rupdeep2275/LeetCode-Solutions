class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] graph = new ArrayList[n+1];
        var seen = new boolean[n+1];
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList<Pair>();
        }
        for(var t : times){
            graph[t[0]].add(new Pair(t[1], t[2]));
        }
        var pq = new PriorityQueue<Pair>((a, b) -> a.time - b.time);
        var res = 0;
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            var p = pq.poll();
            int node = p.node, time = p.time;
            if(seen[node]) continue;
            seen[node] = true;
            res = Math.max(res, time);
            n--;
            for(var nei : graph[node]){
                pq.add(new Pair(nei.node, time + nei.time));
            }
        }
        return n == 0 ? res : -1;
    }
}
class Pair{
    int node, time;
    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
