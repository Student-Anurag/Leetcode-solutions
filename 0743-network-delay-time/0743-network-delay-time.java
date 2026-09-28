class Solution {
    static class pair {
        int node;
        int dist;
        public pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new pair(v, wt));
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> (a.dist - b.dist)
        );
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k] = 0;
        pq.add(new pair(k, 0));
        while(! pq.isEmpty()) {
            pair curr = pq.poll();
            int u = curr.node;
            int currDist = curr.dist;
            if (currDist > res[u]) {
                continue;
            }
            for(pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;
                if(weight + currDist < res[v]) {
                    res[v] = weight + currDist;
                    pq.add(new pair(v, res[v]));
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(res[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, res[i]);
        }
        return ans;
    }
}