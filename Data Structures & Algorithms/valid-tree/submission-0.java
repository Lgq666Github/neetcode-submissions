class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n -1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (vis[v]) continue;
                vis[v] = true;
                count++;
                q.offer(v);
            }
        }
        return count == n;
    }
}
