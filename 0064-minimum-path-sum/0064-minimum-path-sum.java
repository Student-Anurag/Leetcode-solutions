class Solution {
    public int solve(int i, int j, int m, int n, int[][] grid, int[][] dp) {
        if(i == m-1 && j == n-1) {
            // we reached the destination 
            return grid[i][j];
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(i+1 < m) {
            down = grid[i][j] + solve(i+1, j, m, n, grid, dp);
        }
        if(j+1 < n) {
            right = grid[i][j] + solve(i, j+1, m, n, grid, dp);
        }
        return dp[i][j] = Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows+1][cols+1];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        return solve(0, 0, rows, cols, grid, dp);
    }
}