class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        boolean first_char_matched = false;
        if(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            first_char_matched = true;
        }
        if(p.length() >= 2 && p.charAt(1) == '*') {
            boolean not_take = isMatch(s, p.substring(2));
            boolean take = (first_char_matched && isMatch(s.substring(1), p));
            return take || not_take;
        }
        else {
            return (first_char_matched && isMatch(s.substring(1), p.substring(1)));
        }
    }
}