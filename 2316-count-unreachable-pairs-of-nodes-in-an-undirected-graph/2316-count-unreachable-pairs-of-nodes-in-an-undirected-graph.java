class Solution {
    int[] parent;
    int[] rank;
    public int find(int i) {
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }
    public void Union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent == y_parent) return;
        if(rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        }
        else {
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            Union(u, v);
        }
        // create map for storing component corresponding to size
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++) {
            int parent = find(i);
            mp.put(parent, mp.getOrDefault(parent, 0)+1);
        }
        // find result from map
        long res = 0;
        long rem = n;
        for(int key : mp.keySet()) {
            long size = mp.get(key);
            res += size * (rem - size);
            rem -= size;
        }
        return res;
    }
}