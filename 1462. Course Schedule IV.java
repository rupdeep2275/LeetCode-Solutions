class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        var isPrerequisite = new boolean[numCourses][numCourses];
        for(var p : prerequisites){
            isPrerequisite[p[0]][p[1]] = true;
        }
        for(int via=0; via<numCourses; via++){
            for(int source=0; source<numCourses; source++){
                for(int target=0; target<numCourses; target++){
                    isPrerequisite[source][target] = isPrerequisite[source][target] || (isPrerequisite[source][via] && isPrerequisite[via][target]);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(var query : queries){
            res.add(isPrerequisite[query[0]][query[1]]);
        }
        return res;
    }
}
