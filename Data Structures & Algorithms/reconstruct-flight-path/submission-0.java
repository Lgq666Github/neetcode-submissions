class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            graph.computeIfAbsent(t.get(0), x -> new PriorityQueue<>()).offer(t.get(1));
        }    
        dfs("JFK");
        return route;
    }

    private void dfs(String u) {
        PriorityQueue<String> d = graph.get(u);
        while (d != null && !d.isEmpty()) {
            dfs(d.poll());
        }
        route.addFirst(u);
    }
}
