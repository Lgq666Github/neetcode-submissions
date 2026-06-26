class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 组装 (position, speed) 对，并按位置倒序排序
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 1; // 初始化车队数量为1（一辆车也属于一个车队）
        // 计算第一辆车到达终点的时间
        double preTime = (double)(target - pair[0][0]) / pair[0][1];
        for (int i = 1; i < n; i++) {
            // 计算当前车到终点的时间
            double currTime = (double)(target - pair[i][0]) / pair[i][1];
            if (currTime > preTime) { // 如果当前时间大于前一辆车到达时间 则说明可以组成车队
                fleets++;
                preTime = currTime;
            }
        }
        return fleets;
    }
}
