class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int solve(int i, int maxEnd, List<int[]> range, int n) {
        // Already covered the entire garden
        if(maxEnd >= n) return 0;
        // No more intervals
        if(i >= range.size()) {
            return Integer.MAX_VALUE;
        }
        // There is a gap so we can not cover the garden
        if(range.get(i)[0] > maxEnd) {
            return Integer.MAX_VALUE;
        }
        String key = i + "," + maxEnd;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        // Don't open this tap
        int not_open = solve(i+1, maxEnd, range, n);
        // Open this tap
        int next = solve(i+1, Math.max(maxEnd, range.get(i)[1]), range, n);
        int open = Integer.MAX_VALUE;
        // Prevent Integer.MAX_VALUE + 1 overflow
        if(next != Integer.MAX_VALUE) {
            open = 1 + next;
        }
        int ans = Math.min(not_open, open);
        dp.put(key, ans);
        return ans;
    }
    public int minTaps(int n, int[] ranges) {
        List<int[]> range = new ArrayList<>();
        for(int i=0; i<ranges.length; i++) {
            int start = Math.max(0, i-ranges[i]);
            int end = Math.min(n, i+ranges[i]);
            range.add(new int[]{start, end});
        }
        range.sort((a, b) -> Integer.compare(a[0], b[0]));
        int ans = solve(0, 0, range, n);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}