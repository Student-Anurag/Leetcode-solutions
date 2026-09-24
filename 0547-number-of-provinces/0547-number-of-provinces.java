class Solution {
    public void bfs(List<List<Integer>> adj, int u, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vis[u] = true;
        while(! q.isEmpty()) {
            int source = q.poll();
            for(int v : adj.get(source)) {
                if(! vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[adj.size()];
        int count = 0;
        for(int i=0; i<n; i++) {
            if(! vis[i]) {
                bfs(adj, i, vis);
                count++;
            }
        }
        return count;
    }
}