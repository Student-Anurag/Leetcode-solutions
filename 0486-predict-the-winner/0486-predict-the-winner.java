class Solution {
    public int solve(int i, int j, int[] nums) {
        if(i > j) return 0;
        if(i == j) return nums[i];
        int take_i = nums[i] + Math.min(solve(i+2, j, nums), solve(i+1, j-1, nums));
        int take_j = nums[j] + Math.min(solve(i+1, j-1, nums), solve(i, j-2, nums));
        return Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int totalScore = 0;
        for(int x: nums) {
            totalScore += x;
        }
        int player1_Score = solve(0, n-1, nums);
        int player2_Score = totalScore - player1_Score;
        return player1_Score >= player2_Score;
    }
}