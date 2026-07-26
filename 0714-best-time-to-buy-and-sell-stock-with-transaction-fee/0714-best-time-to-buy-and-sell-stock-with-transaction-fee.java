class Solution {
    public int solve(int index, int buy, int n, int[] prices, int fee, int[][] dp) {
        // base case
        if(index == n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + solve(index+1, 0, n, prices, fee, dp),
            solve(index+1, 1, n, prices, fee, dp));
        } else {
            return dp[index][buy] = Math.max(prices[index] - fee + solve(index+1, 1, n, prices, fee, dp),
            solve(index+1, 0, n, prices, fee, dp));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, 1, n, prices, fee, dp);
    }
}