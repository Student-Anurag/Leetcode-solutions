class Solution {
    public boolean solve(int i, int open, String s, int[][] dp) {
        if(i == s.length()) {
            return (open == 0);
        }
        if(dp[i][open] != -1) {
            return dp[i][open] == 1;
        }
        boolean isValid = false;
        if(s.charAt(i) == '*') {
            isValid |= solve(i+1, open+1, s, dp);   // * is treated as '('
            isValid |= solve(i+1, open, s, dp);     // * is treated as ''
            if(open > 0) isValid |= solve(i+1, open-1, s, dp);  // * is treated as ')'
        }
        else {
            if(s.charAt(i) == '(') {
                isValid = solve(i+1, open+1, s, dp);
            }
            else if(open > 0) {
                isValid = solve(i+1, open-1, s, dp);
            }
        }
        dp[i][open] = isValid ? 1 : 0;
        return isValid;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s, dp);
    }
}