class Solution {
    int[] parent;
    int[] rank;
    public int find(int i) {
        if(parent[i] == i) return i;
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
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) { 
            parent[i] = i;
        }
        if(connections.length < n-1) return -1;
        int components = n;
        for(int[] vec : connections) {
            if(find(vec[0]) != find(vec[1])) {
                Union(vec[0], vec[1]);
                components--;
            }
        }
        return components - 1;
    }
}