class Solution {
    public boolean isBipartiteBFS(int[][] graph, int curr, int[] color, int currColor) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        color[curr] = currColor;
        while(! q.isEmpty()) {
            int u = q.poll();
            for(int v : graph[u]) {
                if(color[v] == color[u]) return false;
                if(color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.add(v);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                if(! isBipartiteBFS(graph, i, color, 1)) return false;
            }
        }
        return true;
    }
}