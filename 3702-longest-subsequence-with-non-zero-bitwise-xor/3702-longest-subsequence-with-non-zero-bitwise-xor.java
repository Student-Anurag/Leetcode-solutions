class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean allZero = true;
        int xor = 0;
        for(int i=0; i<n; i++) {
            xor = xor ^ nums[i];
            if(nums[i] != 0) allZero = false;
        }
        if(allZero) return 0;
        return (xor == 0) ? n-1 : n;
    }
}