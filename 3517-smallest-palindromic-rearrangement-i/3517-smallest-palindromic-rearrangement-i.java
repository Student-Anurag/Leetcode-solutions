class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;
        char[] chars = s.toCharArray();
        // chars --> ['d','a','c','c','a','d']
        Arrays.sort(chars, 0, mid); // mid is excluded
        // chars --> ['a','c','d','c','a','d']
        for(int i=0; i<mid; i++) {
            chars[n-i-1] = chars[i];
        }
        // chars --> ['a','c','d','d','c','a']
        return new String(chars);
    }
}