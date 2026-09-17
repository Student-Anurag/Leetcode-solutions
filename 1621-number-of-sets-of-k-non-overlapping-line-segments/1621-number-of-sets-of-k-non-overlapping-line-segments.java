class Solution {
    int M = 1000000007;
    int[][] dp = new int[1001][1001];
    public int solve(int n, int k, int i) {
        if(k == 0) return 1;
        if(i >= n) return 0;
        if(dp[k][i] != -1) return dp[k][i];
        long take = 0;   // start segment from ith point
        for(int j=i+1; j<=n-1; j++) {
            take += (solve(n, k-1, j) % M);
        }
        long skip = solve(n, k, i+1) % M;
        return dp[k][i] = (int)((take + skip) % M);
    }
    public int numberOfSets(int n, int k) {
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, k, 0);
    }
}