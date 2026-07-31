class Solution {
    public int LPS(int start, int end, String s, int[][] dp) {
        // base case
        if(start == end) return 1;
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        if(s.charAt(start) == s.charAt(end)) {
            return dp[start][end] = 2 + LPS(start+1, end-1, s, dp);
        }
        else {
            return dp[start][end] = Math.max(LPS(start+1, end, s, dp), LPS(start, end-1, s, dp));
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return LPS(0, n-1, s, dp);
    }
}