class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        // 起点：四条边上所有的 'O'
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                boolean onBorder = r == 0 || r == m - 1 || c == 0 || c == n - 1;
                if (onBorder && board[r][c] == 'O') {
                    board[r][c] = 'T';
                    q.offer(new int[]{r, c});
                }
            }
        }

        // 多源 BFS：标记所有和边界相连的 'O'
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : DIRS) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (board[nr][nc] != 'O') continue;
                board[nr][nc] = 'T';
                q.offer(new int[]{nr, nc});
            }
        }

        // 最后一遍：'O' 被包围 → 'X'；'T' 安全 → 还原为 'O'
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }
}