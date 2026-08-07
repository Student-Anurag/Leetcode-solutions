class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int res = 1;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                }
            }
            res = Math.max(res, LIS[i]);
        }
        return res;
    }
}