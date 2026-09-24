class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] x : pre) {
            int u = x[0];
            int v = x[1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[numCourses];
        for(int u=0; u<numCourses; u++) {
            for(int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                res.add(i);
            }
        }
        int count = 0;
        while(! q.isEmpty()) {
            int u = q.poll();
            count++;
            for(int v : adj.get(u)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                    res.add(v);
                }
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }
        if(count == numCourses) return ans;
        else return new int[]{};
    }
}