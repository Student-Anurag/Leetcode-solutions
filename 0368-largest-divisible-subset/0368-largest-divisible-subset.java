class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int maxLen = 1, index = 0;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(LDS[i] < 1 + LDS[j]) {
                        LDS[i] = 1 + LDS[j];
                        parent[i] = j;
                    }
                }
            }
            if(maxLen < LDS[i]) {
                maxLen = LDS[i];
                index = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(index != -1) {
            ans.add(nums[index]);
            index = parent[index];
        }
        Collections.reverse(ans);
        return ans;
    }
}