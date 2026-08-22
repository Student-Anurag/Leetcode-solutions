class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=n-2; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int minChoice = matrix[i+1][j];
                if(j > 0) minChoice = Math.min(minChoice, matrix[i+1][j-1]);
                if(j+1 < n) minChoice = Math.min(minChoice, matrix[i+1][j+1]);
                matrix[i][j] += minChoice;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            res = Math.min(res, matrix[0][j]);
        }
        return res;
    }
}