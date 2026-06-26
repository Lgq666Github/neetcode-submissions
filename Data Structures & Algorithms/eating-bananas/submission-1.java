class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 设置香蕉的最小吃速 left = 1，最大吃速 right = piles 中的最大值
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile); // 找到最大的一堆香蕉作为最大吃速
        }

        // 进行二分查找，找到最小的满足 h 小时内吃完香蕉的吃速
        while (left < right) {
            int middle = (left + right) / 2; // 计算当前的中间吃速
            int hourSpent = 0; // 计算按此吃速吃完所有香蕉所需的时间
            
            // 遍历所有香蕉堆，计算总耗时
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle); // 向上取整计算吃完该堆的时间
            }
            
            // 如果当前吃速能在 h 小时内吃完，则尝试更小的吃速
            if (hourSpent <= h) {
                right = middle; // 缩小右边界，尝试更小的吃速
            } else { // 否则吃速太小，时间超出 h，需要增大吃速
                left = middle + 1;
            }
        }
        return right; // 返回最小的满足条件的吃速
    }
}
