class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for(int len=k; len<=n; len++) {
            String res = "";
            for(int i=0; i+len<=n; i++) {
                String tmp = s.substring(i, i+len);
                // count 1's
                int ones = 0;
                for(char ch: tmp.toCharArray()) {
                    if(ch == '1') ones++;
                }
                // keep if it's beautiful and smaller than current best.
                if(ones == k) {
                    if(res.isEmpty() || tmp.compareTo(res) < 0) {
                        res = tmp;
                    }
                }
            }
            // if we find result of len size, it's the smallest no need to len++
            if(! res.isEmpty()) {
                return res;
            }
        }
        return "";
    }
}