class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1; // 终点索引
        for (int i = nums.length - 2; i >= 0; i--) { // 从倒数第二个位置往前遍历
            if (i + nums[i] >= goal) { // 判断当前位置能否跳到或跳过终点
                goal = i; // 更新目标点为当前位置
            }
        }
        return goal == 0; // 如果目标点回到起点，则说明可以跳到终点
    }
}