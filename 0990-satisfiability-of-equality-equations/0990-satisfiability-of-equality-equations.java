class Solution {
    int[] parent;
    int[] rank;
    public int find(int i) {
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void Union(int x, int y) {
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_x == parent_y) return;
        if(rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        }
        else {
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0; i<26; i++) {
            parent[i] = i;
        }
        for(String s : equations) {
            // Do union for equal characters (a==b)
            if(s.charAt(1) == '=') {
                Union(s.charAt(0)-'a', s.charAt(3)-'a');
            }
        }
        for(String s : equations) {
            // find != cases and validate (a!=b)
            if(s.charAt(1) == '!') {
                char first = s.charAt(0);
                char second = s.charAt(3);
                int parent_first = find(first-'a');
                int parent_second = find(second-'a');
                if(parent_first == parent_second) {
                    return false;
                }
            }
        }
        return true;
    }
}