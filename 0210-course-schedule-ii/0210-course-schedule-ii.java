class Solution {
    boolean hasCycle;
    public void DFS(List<List<Integer>> adj, int u, boolean[] vis, boolean[] inRec, Stack<Integer> st) {
        vis[u] = true;
        inRec[u] = true;
        for(int v : adj.get(u)) {
            if(inRec[v]) {
                hasCycle = true;
                return;
            }
            if(! vis[v]) {
                DFS(adj, v, vis, inRec, st);
            }
        }
        st.push(u);
        inRec[u] = false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        hasCycle = false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] x : prerequisites) {
            int course = x[0];
            int prerequisite = x[1];
            adj.get(prerequisite).add(course);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] inRec = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<numCourses; i++) {
            if(! vis[i]) {
                DFS(adj, i, vis, inRec, st);
            }
        }
        if(hasCycle) {
            return new int[]{};
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while(! st.isEmpty()) {
            res[idx++] = st.pop();
        }
        return res;
    }
}