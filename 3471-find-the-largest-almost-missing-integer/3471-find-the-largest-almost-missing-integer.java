class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        // case 1: k = 1
        // return the largest element that occurs exactly once in nums
        if(k == 1) {
            int[] occ = new int[51];
            int max = -1;
            for(int num: nums) {
                occ[num]++;
            }
            for(int i=0; i<n; i++) {
                if(occ[nums[i]] == 1) {
                    max = Math.max(max, nums[i]);
                }
            }
            return max;
        }
        // case 2: k = n
        // return the largest element in nums
        else if(k == n) {
            int max = Integer.MIN_VALUE;
            for(int num: nums) {
                if(num > max) {
                    max = num;
                }
            }
            return max;
        }
        // case 3: 1 < k < n
        else {
            int[] occ = new int[51];
            int max = Integer.MIN_VALUE;
            for(int num: nums) {
                occ[num]++;
            }
            if(occ[nums[0]] == 1 && occ[nums[n-1]] == 1) return Math.max(nums[0], nums[n-1]);
            else if(occ[nums[0]] == 1) return nums[0];
            else if(occ[nums[n-1]] == 1) return nums[n-1];
            else return -1;
        }
    }
}