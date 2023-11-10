class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,List<Integer>> graph = new HashMap();

        for(int[] edge : adjacentPairs){
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList());
            list.add(edge[1]);
            graph.put(edge[0], list);
            list = graph.getOrDefault(edge[1], new ArrayList());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] res = new int[graph.size()];
        res[0] = root;
        int curr = root;
        int i = 1;
        int prev = Integer.MAX_VALUE;

        while (i < graph.size()) {
            for (int neighbor : graph.get(curr)) {
                if (neighbor != prev) {
                    res[i] = neighbor;
                    i++;
                    prev = curr;
                    curr = neighbor;
                    break;
                }
            }
        }

        return res;
    }
}