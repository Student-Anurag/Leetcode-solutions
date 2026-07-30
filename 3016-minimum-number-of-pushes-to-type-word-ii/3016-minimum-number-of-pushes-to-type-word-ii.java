class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n <= 8) return n;
        int[] mp = new int[26];
        for(char ch: word.toCharArray()) {
            mp[ch - 'a']++;
        }
        // sort : descending order of frequency
        Integer[] mpInteger = Arrays.stream(mp).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Collections.reverseOrder());
        int result = 0;
        for(int i=0; i<26; i++) {
            result += mpInteger[i] * (i/8 + 1);
        }
        return result;
    }
}