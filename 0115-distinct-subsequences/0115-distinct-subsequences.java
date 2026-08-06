class Solution {
    public int totalSub(int m, int n, String s, String t, int[][] dp) {
        // base case
        if(n == 0) return 1;
        if(m == 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        if(s.charAt(m-1) == t.charAt(n-1)) {
            return dp[m][n] = totalSub(m-1, n-1, s, t, dp) + totalSub(m-1, n, s, t, dp);
        }
        else return dp[m][n] = totalSub(m-1, n, s, t, dp);
    }
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return totalSub(m, n, s, t, dp);
    }
}