class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);
        
        int[] state = new int[numCourses];     // 0未访问 1访问中 2已完成
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, i, state)) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int u, int[] state) {
        state[u] = 1;
        for (int v : graph.get(u)) {
            if (state[v] == 1) return true;
            if (state[v] == 0 && hasCycle(graph, v, state)) return true;
        }
        state[u] = 2;
        return false;
    }
}
