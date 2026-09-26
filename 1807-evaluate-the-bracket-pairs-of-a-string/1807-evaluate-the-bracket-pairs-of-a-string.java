class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> mp = new HashMap<>();
        for(List<String> vec : knowledge) {
            mp.put(vec.get(0), vec.get(1));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isBracketOpen = false;
        int i = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch == '(') {
                isBracketOpen = true;
            }
            else if(ch == ')') {
                res.append(mp.getOrDefault(temp.toString(), "?"));
                isBracketOpen = false;
                temp = new StringBuilder();
            }
            else if(isBracketOpen) {
                temp.append(ch);
            }
            else {
                res.append(ch);
            }
            i++;
        }
        return res.toString();
    }
}