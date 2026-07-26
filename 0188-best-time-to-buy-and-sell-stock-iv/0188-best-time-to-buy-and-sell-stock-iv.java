class Solution {
    public int Solve(int index, int buy, int transactions, int n, int[] prices, int[][][] dp) {
        // base case
        if(transactions == 0 || index == n) {
            return 0;
        }
        if(dp[index][buy][transactions] != -1) {
            return dp[index][buy][transactions];
        }
        if(buy == 1) {
            // can buy the stock or not buy the stock
            return dp[index][buy][transactions] = Math.max(-prices[index] + Solve(index+1, 0, transactions, n, prices, dp),
            Solve(index+1, 1, transactions, n, prices, dp));
        }
        else {
            // can sell the stock or not sell the stock
            return dp[index][buy][transactions] = Math.max(prices[index] + Solve(index+1, 1, transactions-1, n, prices, dp),
            Solve(index+1, 0, transactions, n, prices, dp));
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Solve(0, 1, k, n, prices, dp);
    }
}