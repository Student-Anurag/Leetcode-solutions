class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0;
        int i = 0, j = 0;
        int[] count = new int[26];
        while(j < n) {
            char ch = s.charAt(j);
            count[ch - 'a']++;
            while(count[ch - 'a'] > 2) {
                count[s.charAt(i) - 'a']--;
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}