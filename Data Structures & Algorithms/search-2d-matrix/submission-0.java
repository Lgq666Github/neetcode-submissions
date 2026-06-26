class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int top = 0, bot = ROWS - 1; // 第一行指针 最后一行指针
        // 确定target在哪一行
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) { // 如果 target 大于该行的最后一个元素
                top = row + 1;
            } else if (target < matrix[row][0]) { // 如果 target 小于该行的第一个元素
                bot = row - 1;
            } else {
                break;
            }
        }
        // 如果 top > bot，说明 target 不在矩阵中
        if (!(top <= bot)) {
            return false;
        }
        // 在目标行中使用二分查找
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
