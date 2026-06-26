class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        // 遍历字符串 s 的每个字符，逐个记录每个字符在字符串中的最后一次出现的索引
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            // 判断当前索引i是否达到了end。如果是，说明当前子字符串已经遍历完，满足条件：所有字符都在该子字符串内
            if (i == end) {
                res.add(size);
                // 重置 size，准备记录下一个子字符串的长度
                size = 0;
            }
        }
        return res;
    }
}