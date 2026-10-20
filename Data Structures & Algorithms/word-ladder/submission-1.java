class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> words = new ArrayList<>(wordList);
        if (!words.contains(endWord)) return 0;
        if (!words.contains(beginWord)) words.add(beginWord);

        // 两两比较，建图
        Map<String, List<String>> graph = new HashMap<>();
        for (String w : words) graph.put(w, new ArrayList<>());
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (diffByOne(words.get(i), words.get(j))) {
                    graph.get(words.get(i)).add(words.get(j));
                    graph.get(words.get(j)).add(words.get(i));
                }
            }
        }

        // 按层 BFS
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;                               // beginWord 本身算一个
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return steps;
                for (String next : graph.get(cur)) {
                    if (visited.add(next)) q.offer(next);
                }
            }
            steps++;
        }
        return 0;
    }

    private boolean diffByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++diff > 1) return false;
        }
        return diff == 1;
    }
}