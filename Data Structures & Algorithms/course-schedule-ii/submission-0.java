class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;                // 唯一的改动：记录出队顺序
            for (int v : graph.get(u)) {
                if (--indegree[v] == 0) q.offer(v);
            }
        }
        return idx == numCourses ? order : new int[0];
    }
}
