class Solution {
    public int solve(int index, int buy, int n, int[] prices, int[][] dp) {
        // base case
        if(index >= n) return 0;
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1) {
            // Either you can buy or not buy on that day
            return dp[index][buy] = Math.max(-prices[index] + solve(index+1, 0, n, prices, dp),
                            solve(index+1, 1, n, prices, dp));
        }
        else {
            // Either you can sell or not sell
            // If sell you can skip the next day because you can't buy stock on the next day
            return dp[index][buy] = Math.max(prices[index] + solve(index+2, 1, n, prices, dp),
                            solve(index+1, 0, n, prices, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, 1, n, prices, dp);
    }
}