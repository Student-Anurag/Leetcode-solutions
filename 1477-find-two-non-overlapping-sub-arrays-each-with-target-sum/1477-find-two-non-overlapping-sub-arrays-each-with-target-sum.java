class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        int[] minLenTillIdx = new int[n];
        Arrays.fill(minLenTillIdx, Integer.MAX_VALUE);
        int bestMin = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while(j < n) {
            // expand window
            sum += arr[j];
            while(i < j && sum > target) {
                sum -= arr[i];
                i++;
            }
            if(sum == target) {
                int len = j - i + 1;
                if(i > 0 && minLenTillIdx[i-1] != Integer.MAX_VALUE) {
                    res = Math.min(res, len + minLenTillIdx[i-1]);
                }
                bestMin = Math.min(bestMin, len);
            }
            minLenTillIdx[j] = bestMin;
            j++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}