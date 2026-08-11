class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int pos = 1, sum = nums[0];
        while(pos < n && nums[pos] == nums[pos-1] + 1) {
            sum += nums[pos];
            pos++;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(nums[i]);
        }
        while(set.contains(sum)) {
            sum++;
        }
        return sum;
    }
}