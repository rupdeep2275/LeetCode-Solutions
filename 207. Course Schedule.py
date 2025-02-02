#Python:

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0] * numCourses
        graph = [[] for _ in range(numCourses)]
        for p in prerequisites:
            graph[p[1]].append(p[0])
            inDegree[p[0]] += 1
        q = deque()
        for i in range(numCourses):
            if inDegree[i] == 0:
                q.append(i)
        while q:
            course = q.popleft()
            for nei in graph[course]:
                inDegree[nei] -= 1
                if inDegree[nei] == 0:
                    q.append(nei)
        for x in inDegree:
            if x != 0:
                return False
        return True

#Java:

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var inDegree = new int[numCourses];
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
        while(!q.isEmpty()){
            var course = q.poll();
            for(var nei : graph[course]){
                inDegree[nei]--;
                if(inDegree[nei] == 0) q.add(nei);
            }
        }
        for(var x : inDegree) if(x != 0) return false;
        return true;
    }
}
