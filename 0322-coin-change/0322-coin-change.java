class Solution {
    static long[][] dp;
    public long coins(int i, int[] coins, int amount){
        if(i==coins.length){
            if(amount==0)   return 0;   // no coins left
            else    return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1)   return dp[i][amount];
        long skip = coins(i+1,coins,amount);
        if(coins[i] > amount)   return dp[i][amount] = skip;
        long pick = 1 + coins(i,coins,amount-coins[i]);
        return dp[i][amount] = Math.min(pick,skip);
    }
    public int coinChange(int[] coins, int amount) {
        // i --> 0 to n-1
        // amount --> amount to 0(min)
        int n = coins.length;
        dp = new long[n][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] =-1;
            }
        }
        int ans = (int) coins(0,coins,amount);
        return (ans==Integer.MAX_VALUE) ? -1 : ans;
    }
}