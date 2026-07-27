class Solution {
    public long maxProfit(int index, int buy, int transactions, int n, int[] prices, long[][][] dp) {
        // base case
        if(transactions == 0) return 0;
        if(index == n) {
            return buy == 0 ? Integer.MIN_VALUE : 0;
        }
        if(dp[index][buy][transactions] != -1) return dp[index][buy][transactions];
        if(buy == 2) {
            // you can either buy or not buy or short buy
            return dp[index][buy][transactions] = Math.max(maxProfit(index+1, 2, transactions, n, prices, dp), Math.max(-prices[index] + maxProfit(index+1, 1, transactions, n, prices, dp), prices[index] + maxProfit(index+1, 0, transactions, n, prices, dp)));
        }
        else if(buy == 1) {
            // normal sell or not sell
            return dp[index][buy][transactions] = Math.max(maxProfit(index+1, 1, transactions, n , prices, dp), prices[index] + maxProfit(index+1, 2, transactions-1, n, prices, dp));
        }
        else {
            // short sell or not short sell
            return dp[index][buy][transactions] = Math.max(maxProfit(index+1, 0, transactions, n, prices, dp), -prices[index] + maxProfit(index+1, 2, transactions-1, n, prices, dp));
        }
    }
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n+1][3][k+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfit(0, 2, k, n, prices, dp);
    }
}