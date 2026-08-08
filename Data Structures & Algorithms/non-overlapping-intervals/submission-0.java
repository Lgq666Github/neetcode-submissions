class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按结束时间从小到大排序
        // 贪心核心：结束越早的区间，留给后面的空间越多，优先保留
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;                          // 记录需要删除的区间数
        int prevEnd = intervals[0][1];          // 第一个区间（结束最早）默认保留，记下它的结束时间

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // 当前区间的开始时间 < 上一个保留区间的结束时间 → 重叠了
                count++;
                // 删除当前这个区间（因为它结束时间更晚，对后面更不利）
                // 注意：prevEnd 不更新，继续保留原来那个结束更早的区间
            } else {
                // 不重叠，保留当前区间
                prevEnd = intervals[i][1];  // 更新"最新保留区间"的结束时间
            }
        }

        return count;  // 返回一共删除了多少个区间
    }
}