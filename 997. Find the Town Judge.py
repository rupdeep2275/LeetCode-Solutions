#Python:

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        in_degrees = [0] * (n+1)
        out_degrees = [0] * (n+1)
        for t in trust:
            in_degrees[t[1]] += 1
            out_degrees[t[0]] += 1
        for i in range(1, n+1):
            if in_degrees[i] == n-1 and out_degrees[i] == 0:
                return i
        return - 1

#Java:

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];
        for(int[] relation : trust){
            outDegrees[relation[0]]++;
            inDegrees[relation[1]]++;
        }
        for(int i=1; i<=n; i++){
            if(outDegrees[i] == 0 && inDegrees[i] == n - 1) return i;
        }
        return -1;
    }
}
