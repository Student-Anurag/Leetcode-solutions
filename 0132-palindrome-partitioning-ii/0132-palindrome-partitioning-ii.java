class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        // Build the palindrome table
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(s.charAt(i) == s.charAt(j) &&
                (j-i <= 2 || pal[i+1][j-1])) {
                    pal[i][j] = true;
                }
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(pal[i][j]) {
                    if(j == n-1) dp[i] = 0; // no cuts required
                    else dp[i] = Math.min(dp[i], 1 + dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}