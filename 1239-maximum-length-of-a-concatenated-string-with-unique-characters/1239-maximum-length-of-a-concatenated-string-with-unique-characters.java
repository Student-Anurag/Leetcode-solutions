class Solution {
    public boolean hasDuplicate(String s1, String s2) {
        int[] count = new int[26];
        for(char ch1: s1.toCharArray()) {
            if(count[ch1 - 'a'] > 0) {
                return true;
            }
            count[ch1 - 'a']++;
        }
        for(char ch2: s2.toCharArray()) {
            if(count[ch2 - 'a'] > 0) {
                return true;
            }
        }
        return false;   // no duplicates found
    }
    public int solve(int i, List<String> arr, String temp, int n) {
        if(i >= n) {
            return temp.length();
        }
        int exclude = 0;
        int include = 0;
        if(hasDuplicate(arr.get(i), temp)) {
            exclude = solve(i+1, arr, temp, n);
        }else {
            exclude = solve(i+1, arr, temp, n);
            include = solve(i+1, arr, temp + arr.get(i), n);
        }
        return Math.max(include, exclude);
    }
    public int maxLength(List<String> arr) {
        int n = arr.size();
        return solve(0, arr, "", n);
    }
}