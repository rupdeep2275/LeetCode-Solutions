class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballMap = new HashMap<>(), colorMap = new HashMap<>();
        var res = new int[queries.length];
        // ball - color, color - freq
        for(int i=0; i<queries.length; i++){
            int ball = queries[i][0], color = queries[i][1];
            if(ballMap.containsKey(ball)){
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if(colorMap.get(prevColor) == 0){
                    colorMap.remove(prevColor);
                }
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            res[i] = colorMap.size();
        }
        return res;
    }
}
