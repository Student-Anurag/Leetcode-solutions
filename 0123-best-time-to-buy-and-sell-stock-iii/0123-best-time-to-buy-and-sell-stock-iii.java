class Solution {
    public int maxProfit(int index, int buy, int transactions, int n, int[] prices, int[][][] dp) {
        // base case
        if(transactions == 0 || index == n) {
            return 0;
        }
        if(dp[index][buy][transactions] != -1) {
            return dp[index][buy][transactions];
        }
        if(buy == 1) {
            // can buy the stock or not buy the stock
            return dp[index][buy][transactions] = Math.max(-prices[index] + maxProfit(index+1, 0, transactions, n, prices, dp),
            maxProfit(index+1, 1, transactions, n, prices, dp));
        }
        else {
            // can sell the stock or not sell the stock
            return dp[index][buy][transactions] = Math.max(prices[index] + maxProfit(index+1, 1, transactions-1, n, prices, dp),
            maxProfit(index+1, 0, transactions, n, prices, dp));
        }
    }

    // index = 0 to n --> (n+1)
    // buy = 0 to 1 --> (2)
    // transactions = 2, 1, 0 --> (3)

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfit(0, 1, 2, n, prices, dp);
    }
}