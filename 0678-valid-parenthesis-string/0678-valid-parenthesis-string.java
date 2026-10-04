class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp  =new boolean[n+1][n+1];
        dp[n][0] = true;
        for(int i=n-1; i>=0; i--) {
            for(int open=0; open<n; open++) {
                boolean isValid = false;
                if(s.charAt(i) == '*') {
                    isValid |= dp[i+1][open+1];
                    isValid |= dp[i+1][open];
                    if(open > 0) isValid |= dp[i+1][open-1];
                }
                else {
                    if(s.charAt(i) == '(') {
                        isValid = dp[i+1][open+1];
                    }
                    else if(open > 0) {
                        isValid = dp[i+1][open-1];
                    }
                }
                dp[i][open] = isValid;
            }
        }
        return dp[0][0];
    }
}