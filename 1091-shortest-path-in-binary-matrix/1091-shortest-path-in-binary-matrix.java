class Solution {
    // all possible 8 directions
    int[][] directions = {
        {1, 1},
        {1, 0},
        {0, 1},
        {-1, -1},
        {0, -1},
        {-1, 0},
        {1, -1},
        {-1, 1}
    };
    public boolean isSafe(int x, int y, int n) {
        return (x >= 0) && (x < n) && (y >= 0) && (y < n);
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 0 || grid[0][0] != 0) {
            return -1;
        }
        // Queue of {row, column}
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0});
        // Mark visited
        grid[0][0] = 1;
        int levels = 1;
        while(! q.isEmpty()) {
            int N = q.size();
            while(N-- > 0) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                // reached the dest
                if(x == n-1 && y == n-1) {
                    return levels;
                }
                for(int[] dir : directions) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];
                    // check boundaries and the cell is unvisited
                    if(isSafe(x_, y_, n) && grid[x_][y_] == 0) {
                        q.add(new int[]{x_, y_});
                        grid[x_][y_] = 1;
                    }
                }
            }
            levels++;
        }
        return -1;
    }
}