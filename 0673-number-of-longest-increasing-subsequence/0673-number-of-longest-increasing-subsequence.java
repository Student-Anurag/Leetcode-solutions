class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int[] count = new int[n];   // -> needed to count the LIS with max value
        Arrays.fill(count, 1);
        int maxLen = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    if(LIS[i] < 1 + LIS[j]) {
                        LIS[i] = 1 + LIS[j];
                        count[i] = count[j];
                    }
                    else if(LIS[i] == 1 + LIS[j]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, LIS[i]);
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            if(maxLen == LIS[i]) {
                res += count[i];
            }
        }
        return res;
    }
}