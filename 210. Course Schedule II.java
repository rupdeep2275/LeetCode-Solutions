class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses], res = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList<Integer>();
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0) q.add(i);
        }
        int i = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            res[i++] = course;
            for(int nei : graph[course]){
                if(--inDegree[nei] == 0) q.add(nei);
            }
        }
        return i < numCourses ? new int[]{} : res;
    }
}
