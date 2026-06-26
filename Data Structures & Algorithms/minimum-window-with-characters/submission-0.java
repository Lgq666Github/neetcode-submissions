public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return ""; // 如果 t 为空，直接返回空字符串

        Map<Character, Integer> countT = new HashMap<>(); // 统计 t 中字符的出现次数
        Map<Character, Integer> window = new HashMap<>(); // 记录当前窗口中的字符频率

        // 统计 t 中字符出现的次数
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size(); // `have` 记录窗口内匹配的字符种类数，`need` 是 t 中不同字符的总数
        int[] res = {-1, -1}; // 记录最小窗口的起始和结束位置
        int resLen = Integer.MAX_VALUE; // 记录最小窗口的长度

        int l = 0; // 左指针
        for (int r = 0; r < s.length(); r++) { // 右指针遍历 s
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1); // 将 c 加入窗口

            // 如果 c 是 t 中的字符，且当前窗口中 c 的频率刚好与 t 中匹配，`have` 增加
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // 当窗口满足 `t` 中所有字符后，尝试缩小窗口
            while (have == need) {
                // 记录更短的窗口
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                // 移除左侧字符，缩小窗口
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                // 如果移除的字符影响了 `have`（减少了 `t` 中的一个关键字符），`have` 也减少
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++; // 移动左指针
            }
        }

        // 如果 `resLen` 仍然是初始值，说明没有符合的子串，返回空字符串
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
