class Solution {
    Integer[][][] dp;
    int[] prices;
    public int maxProfit(int k, int[] prices) {
        this.dp = new Integer[prices.length][k+1][2];
        this.prices = prices;
        return dp(0, k, 0);
    }
    int dp(int i, int transactionsRem, int holding){
        if(transactionsRem == 0 || i == prices.length) return 0;
        if(dp[i][transactionsRem][holding] != null) return dp[i][transactionsRem][holding];
        int doNothing = dp(i+1, transactionsRem, holding);
        int doSomething = 0;
        if(holding == 0){
            doSomething = -prices[i] + dp(i+1, transactionsRem, 1);
        }
        else{
            doSomething = prices[i] + dp(i+1, transactionsRem - 1, 0);
        }
        return dp[i][transactionsRem][holding] = Math.max(doSomething, doNothing);
    }
}
