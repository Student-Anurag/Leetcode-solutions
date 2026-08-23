class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftKnownSum = 0, rightKnownSum = 0;
        int leftQnMarksCount = 0, rightQnMarksCount = 0;
        for(int i=0; i<n; i++) {
            char ch = num.charAt(i);
            if(ch == '?') {
                if(i < n/2) leftQnMarksCount++;
                else rightQnMarksCount++;
            } else {
                if(i < n/2) leftKnownSum += ch - '0';
                else rightKnownSum += ch - '0';
            }
        }
        int totalQnMarks = leftQnMarksCount + rightQnMarksCount;
        if(totalQnMarks % 2 == 1) {
            // odd -> Alice always wins
            return true;
        }
        int LEFT = 2 * leftKnownSum + 9 * leftQnMarksCount;
        int RIGHT = 2 * rightKnownSum + 9 * rightQnMarksCount;
        if(LEFT == RIGHT) return false;
        return true;
    }
}