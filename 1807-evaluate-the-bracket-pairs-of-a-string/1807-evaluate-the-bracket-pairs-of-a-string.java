class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> mp = new HashMap<>();
        for(List<String> vec : knowledge) {
            mp.put(vec.get(0), vec.get(1));
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(ch == '(') {
                int j = s.indexOf(")", i+1);
                String temp = s.substring(i+1, j);
                res.append(mp.getOrDefault(temp, "?"));
                i = j;
            }
            else {
                res.append(ch);
            }
            i++;
        }
        return res.toString();
    }
}