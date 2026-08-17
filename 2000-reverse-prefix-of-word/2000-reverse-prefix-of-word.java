class Solution {
    public String reversePrefix(String word, char ch) {
        int occuranceIdx = -1;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == ch) {
                occuranceIdx = i;
                break;
            }
        }
        String sub = word.substring(0, occuranceIdx+1);
        StringBuilder sb = new StringBuilder(sub);
        return (occuranceIdx != -1) ? sb.reverse().toString() + word.substring(occuranceIdx+1) : word;
    }
}