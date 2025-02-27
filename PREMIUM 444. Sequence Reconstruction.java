class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        HashSet<Integer>[] graph = new HashSet[n+1];
        var indegree = new int[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new HashSet<Integer>();
        }
        for(var sequence: sequences){
            for(int i=0; i<sequence.size()-1;i++){
                int u = sequence.get(i), v = sequence.get(i+1);
                if(!graph[u].contains(v)){
                    indegree[v]++;
                    graph[u].add(v);
                }
            }
        }
        var q = new LinkedList<Integer>();
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int idx = 0;
        while(!q.isEmpty()){
            if(q.size() > 1) return false;
            int node = q.poll();
            if(nums[idx] != node) return false;
            idx++;
            for(int nei : graph[node]){
                indegree[nei]--;
                if(indegree[nei] == 0) q.add(nei);
            }
        }
        return idx == n;
    }
}
