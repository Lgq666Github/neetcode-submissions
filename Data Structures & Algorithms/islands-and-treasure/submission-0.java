class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        int m = grid.length, n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    bfs(grid, r, c, m, n);
                }
            }
        }
    }

    private void bfs(int[][] grid, int sr, int sc, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            for (int[] dir: DIRS) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    if (d + 1 < grid[nr][nc]) {
                        grid[nr][nc] = d + 1;
                    }
                    q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }
    }
}
