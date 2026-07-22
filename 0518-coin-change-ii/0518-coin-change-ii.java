class Solution {
    public int totalWays(int n, int amount, int[] coins, int[][] dp) {
        if(amount == 0) return 1;
        if(n == 0 || amount < 0) return 0;
        if(dp[n][amount] != -1) return dp[n][amount];
        return dp[n][amount] = totalWays(n-1, amount, coins, dp) + totalWays(n, amount-coins[n-1], coins, dp);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] a: dp) {
            Arrays.fill(a, -1);
        }
        return totalWays(n, amount, coins, dp);
    }
}