class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], res = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(var i=0; i<numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(var p : prerequisites){
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        var q = new LinkedList<Integer>();
        for(var i=0; i<numCourses; i++){
            if(inDegree[i] == 0) q.add(i);
        }
        var i = 0;
        while(!q.isEmpty()){
            var course = q.poll();
            res[i++] = course;
            for(var nei : graph[course]){
                if(--inDegree[nei] == 0) q.add(nei);
            }
        }
        for(var x : inDegree) if(x != 0) return new int[]{};
        return res;
    }
}
