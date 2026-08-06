class Solution {
    public int solve(int m, int n, String word1, String word2, int[][] dp) {
        // base condition
        if(m == 0)  return n;
        if(n == 0)  return m;
        if(dp[m][n] != -1) return dp[m][n];
        if(word1.charAt(m-1) == word2.charAt(n-1)) {
            return dp[m][n] = solve(m-1, n-1, word1, word2, dp);
        }
        else {
            int insert = 1 + solve(m, n-1, word1, word2, dp);
            int delete = 1 + solve(m-1, n, word1, word2, dp);
            int replace = 1 + solve(m-1, n-1, word1, word2, dp);
            return dp[m][n] = Math.min(insert, Math.min(delete, replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(m, n, word1, word2, dp);
    }
}