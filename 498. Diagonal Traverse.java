class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> diaMap = new HashMap<>();
        for(int i=mat.length-1; i>=0; i--){
            for(int j=0; j<mat[0].length; j++){
                int dia = i + j;
                diaMap.computeIfAbsent(dia, k -> new ArrayList()).add(mat[i][j]);
            }
        }
        int i = 0, curr = 0, n = mat.length * mat[0].length;
        int[] res = new int[n];
        while(diaMap.containsKey(curr)){
            if(curr % 2 == 0) for(int num : diaMap.get(curr)) res[i++] = num;
            else{
                List<Integer> list = diaMap.get(curr);
                for(int j=list.size()-1; j>=0; j--) res[i++] = list.get(j);
            }
            curr++;
        }
        return res;
    }
}
