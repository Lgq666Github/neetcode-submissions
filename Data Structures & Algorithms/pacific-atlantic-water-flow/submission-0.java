class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Deque<int[]> pq = new ArrayDeque<>(), aq = new ArrayDeque<>();

        // 起点：边界格子
        for (int r = 0; r < m; r++) {
            pacific[r][0] = true;      pq.offer(new int[]{r, 0});        // 左边
            atlantic[r][n - 1] = true; aq.offer(new int[]{r, n - 1});    // 右边
        }
        for (int c = 0; c < n; c++) {
            if (!pacific[0][c])      { pacific[0][c] = true;      pq.offer(new int[]{0, c}); }      // 上边
            if (!atlantic[m - 1][c]) { atlantic[m - 1][c] = true; aq.offer(new int[]{m - 1, c}); }  // 下边
        }

        bfs(heights, pq, pacific, m, n);
        bfs(heights, aq, atlantic, m, n);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (pacific[r][c] && atlantic[r][c])
                    res.add(Arrays.asList(r, c));
        return res;
    }

    private void bfs(int[][] h, Deque<int[]> q, boolean[][] reach, int m, int n) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (reach[nr][nc]) continue;
                if (h[nr][nc] < h[r][c]) continue;      // 逆流：只能往高处或等高处走
                reach[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}