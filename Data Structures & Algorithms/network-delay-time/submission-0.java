class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        for (int round = 0; round < n - 1; round++) {
            boolean changed = false;
            for (int[] t : times) {
                int u = t[0], v = t[1], w = t[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    changed = true;
                }
            }
            if (!changed) break;    // no update in this round
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
