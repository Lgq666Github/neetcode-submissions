class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inTree = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0});                      // {代价, 节点}

        int cost = 0, count = 0;
        while (count < n) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (inTree[u]) continue;                    // 过期条目：u 已经在树里了
            inTree[u] = true;
            cost += d;
            count++;
            for (int v = 0; v < n; v++) {
                if (inTree[v]) continue;
                int w = Math.abs(points[u][0] - points[v][0])
                      + Math.abs(points[u][1] - points[v][1]);
                pq.offer(new int[]{w, v});
            }
        }
        return cost;
    }
}