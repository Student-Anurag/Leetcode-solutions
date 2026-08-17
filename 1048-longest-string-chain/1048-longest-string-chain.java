class Solution {
    public boolean isPredecessor(String a, String b) {
        if(a.length() != 1 + b.length()) return false;
        int i = a.length() - 1, j = b.length() - 1;
        int mismatchAllowed = 0;
        while(i >= 0 && j >= 0) {
            if(a.charAt(i) == b.charAt(j)) {
                i--;    j--;
            }
            else {
                mismatchAllowed++;
                i--;
            }
        }
        return mismatchAllowed <= 1;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        // sort in basis of size
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] LCS = new int[n];
        Arrays.fill(LCS, 1);
        int maxLen = 1;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(isPredecessor(words[i], words[j])) {
                    LCS[i] = Math.max(LCS[i], 1 + LCS[j]);
                }
            }
            maxLen = Math.max(maxLen, LCS[i]);
        }
        return maxLen;
    }
}