public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];  // 存放最终结果
        Deque<Integer> q = new LinkedList<>();  // 双端队列，存储索引
        int l = 0, r = 0;  // l 表示窗口左边界, r 表示右边界

        while (r < n) {
            // 维护单调递减队列：保证队列存储的索引对应的数值是从大到小排列
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();  // 移除队尾较小的元素
            }
            q.addLast(r);  // 把当前索引 r 加入队列

            // 移除超出窗口范围的元素（即队列前端索引超出窗口左边界 l）
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // 当窗口大小达到 k 时，记录最大值到结果数组
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];  // 队列首部索引对应的元素是窗口最大值
                l++;  // 右移窗口左边界
            }
            r++;  // 右移窗口右边界
        }

        return output;  // 返回滑动窗口最大值数组
    }
}
