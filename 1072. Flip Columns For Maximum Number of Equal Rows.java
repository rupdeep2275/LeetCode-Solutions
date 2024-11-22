class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        var map = new HashMap<String, Integer>();
        for(var row : matrix){
            var x = row[0];
            var sb = new StringBuilder();
            for(var num : row){
                if(num == x) sb.append('T');
                else sb.append('F');
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        var res = 0;
        for(var num : map.values()){
            res = Math.max(num, res);
        }
        return res;
    }
}
