class Solution {
    static class Pair {
        int wt;
        int node;
        Pair(int wt, int node) {
            this.wt = wt;
            this.node = node;
        }
    }
    public int minCost(List<List<Pair>> adj, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(0, 0));
        int sum = 0;
        boolean[] vis = new boolean[V];
        while(! pq.isEmpty()) {
            Pair curr = pq.poll();
            int wt = curr.wt;
            int node = curr.node;
            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;          
            for(Pair neighbor : adj.get(node)) {
                if(! vis[neighbor.node]) {
                    pq.offer(new Pair(neighbor.wt, neighbor.node));
                }
            }
        }
        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++) {
            for(int j=i+1; j<V; j++) {
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new Pair(dist, j));
                adj.get(j).add(new Pair(dist, i));
            }
        }
        return minCost(adj, V);
    }
}