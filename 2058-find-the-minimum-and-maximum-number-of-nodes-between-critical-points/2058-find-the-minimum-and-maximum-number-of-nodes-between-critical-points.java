class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode tmp = head.next;
        ListNode prev = head;
        int cp = 1;
        List<Integer> l = new ArrayList<>();
        while(tmp.next != null) {
            if(tmp.val < prev.val && tmp.val < tmp.next.val) {
                l.add(cp+1);
            }
            if(tmp.val > prev.val && tmp.val > tmp.next.val) {
                l.add(cp+1);
            }
            tmp = tmp.next;
            prev = prev.next;
            cp++;
        }
        if(l.size() < 2) return new int[]{-1, -1};
        int minD = Integer.MAX_VALUE;
        int maxD = l.get(l.size()-1) - l.get(0);
        for(int i=1; i<l.size(); i++) {
            int diff = l.get(i) - l.get(i-1);
            if(diff < minD) minD = diff;
        }
        return new int[]{minD, maxD};
    }
}