class Solution {
    public int LCS(int m, int n, String text1, String text2, int[][] dp) {
        // base case
        if(m == 0 || n == 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(text1.charAt(m-1) == text2.charAt(n-1)) {
            return dp[m][n] = 1 + LCS(m-1, n-1, text1, text2, dp);
        }
        else {
            return dp[m][n] = Math.max(LCS(m-1, n, text1, text2, dp), LCS(m, n-1, text1, text2, dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return LCS(m, n, text1, text2, dp);
    }
}