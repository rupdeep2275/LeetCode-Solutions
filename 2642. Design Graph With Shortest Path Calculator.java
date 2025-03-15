class Graph {
    ArrayList<Pair>[] graph;
    int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) addEdge(edge);
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0], to = edge[1], cost = edge[2];
        graph[from].add(new Pair(to, cost));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Pair(node1, 0));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node, cost = curr.cost;
            if (node == node2) return dist[node2];
            if (cost > dist[node]) continue;
            for (Pair neighbor : graph[node]) {
                int nextNode = neighbor.node, nextCost = neighbor.cost;
                if (dist[node] + nextCost < dist[nextNode]) {
                    dist[nextNode] = dist[node] + nextCost;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        return -1; 
    }
}
class Pair {
    int node;
    int cost;
    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
