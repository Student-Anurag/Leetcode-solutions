class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;
        for(String word: words) {
            int current = 1;
            for(int i=0; i<word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i+1);
                if(dp.containsKey(predecessor)) {
                    current = Math.max(current, 1 + dp.get(predecessor));
                }
            }
            dp.put(word, current);
            maxLen = Math.max(maxLen, current);
        }
        return maxLen;
    }
}