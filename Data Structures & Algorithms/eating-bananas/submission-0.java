public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; // 最小吃香蕉速度
        int r = Arrays.stream(piles).max().getAsInt(); // 最大吃香蕉速度（最多的那一堆）
        int res = r; // 记录最终的最小可行的 k

        while (l <= r) { // 进行二分查找
            int k = (l + r) / 2; // 取当前二分的吃香蕉速度
            long totalTime = 0; // 计算用当前速度吃完所有香蕉所需的时间

            for (int p : piles) { // 遍历每一堆香蕉
                totalTime += Math.ceil((double) p / k); // 向上取整计算当前堆的耗时
            }

            if (totalTime <= h) { // 如果能在 h 小时内吃完
                res = k; // 记录当前速度 k
                r = k - 1; // 尝试更小的 k
            } else { // 吃不完，说明 k 太小了
                l = k + 1;
            }
        }
        return res; // 返回最小的可行 k
    }
}