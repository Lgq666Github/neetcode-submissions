class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];

        // 入度 = 比自己小的邻居个数
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] < matrix[r][c]) {
                        indegree[r][c]++;
                    }
                }
            }
        }

        // 起点：所有局部最小值
        Deque<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (indegree[r][c] == 0) q.offer(new int[]{r, c});

        int layers = 0;
        while (!q.isEmpty()) {
            layers++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (matrix[nr][nc] <= matrix[r][c]) continue;   // 只沿着递增方向
                    if (--indegree[nr][nc] == 0) q.offer(new int[]{nr, nc});
                }
            }
        }
        return layers;
    }
}