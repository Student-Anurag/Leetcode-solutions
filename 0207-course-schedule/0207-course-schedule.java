class Solution {
    public boolean isCycleDFS(List<List<Integer>> adj, int u, boolean[] vis, boolean[] inRec) {
        vis[u] = true;
        inRec[u] = true;
        for(int v : adj.get(u)) {
            if(! vis[v] && isCycleDFS(adj, v, vis, inRec)) {
                return true;    // cycle present
            }
            else if(inRec[v]) {
                return true;    // cycle present
            }
        }
        inRec[u] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create an adjacency list representation of graph
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
        for(int i=0; i<numCourses; i++) {
            if(! vis[i] && isCycleDFS(adj, i, vis, inRec)) {
                return false;   // all courses can never be completed
            }
        }
        return true;    // all courses can be completed
    }
}