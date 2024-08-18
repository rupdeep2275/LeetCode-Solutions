class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for(var p : prices){
            min = Math.min(p, min);
            res = Math.max(res, p - min);
        }
        return res;
    }
}
