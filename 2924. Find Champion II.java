class Solution {
    public int findChampion(int n, int[][] edges) {
        var inDegree = new int[n];
        int champCount = 0, champ = -1;
        for(var edge : edges) inDegree[edge[1]]++;
        for(var i=0; i<n; i++){
            if(inDegree[i] == 0){
                champCount++;
                champ = i;
            }
        }
        return champCount > 1 ? -1 : champ;
    }
}
